#! /bin/bash

REGENERATE=false

function sizes() {
  ls -d memory-singlearea-fullhistory-00-*.xmi | cut -d - -f5 | cut -d . -f1 | sort | uniq
}

plotfile=simmemory.dat

if [[ $REGENERATE == true ]]; then

  echo Generating $plotfile...

  echo 'Size "XMI Before" "XMI After" "TEMF Before" "TEMF After"'  > $plotfile

  for size in $(sizes); do
      
    xmibefore=$(cat memory-singlearea-fullhistory-00-$size.xmi/java-0.log \
      | sed -ne 's|^.*simulate -- Using \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) MB out of \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) MB before saving|\1\2|p')

    xmiafter=$(cat memory-singlearea-fullhistory-00-$size.xmi/java-0.log \
      | sed -ne 's|^.*simulate -- Using \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) MB out of \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) MB after saving|\1\2|p')

    temfbefore=$(cat memory-singlearea-nohistory-00-$size.temf/java-0.log \
      | sed -ne 's|^.*simulate -- Using \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) MB out of \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) MB before saving|\1\2|p')

    temfafter=$(cat memory-singlearea-nohistory-00-$size.temf/java-0.log \
      | sed -ne 's|^.*simulate -- Using \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) MB out of \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) MB after saving|\1\2|p')

    if [ -z $xmibefore ]; then
          xmibefore=!
    fi
    if [ -z $xmiafter ]; then
          xmiafter=!
    fi
    if [ -z $temfbefore ]; then
          temfbefore=!
    fi
    if [ -z $temfbefore ]; then
          temfbefore=!
    fi

echo $size $xmibefore $xmiafter $temfbefore $temfafter >> $plotfile

  done
fi

gnuplot -p << EOF | cat
	set terminal pdf;
	set title "Memory usage";
	set xlabel "Size";
	set ylabel "Memory Usage (MB)";
	set format y "%.0f";
	set output "simmemory.pdf";
  set logscale x 2;
  set logscale y 2;
	plot for [IDX=2:5] "$plotfile" using 1:IDX with linespoint title columnheader(IDX);
EOF
