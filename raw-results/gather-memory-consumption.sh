#! /bin/bash

REGENERATE=false

function sizes() {
  ls -d memory-singlearea-fullhistory-00-*.xmi | cut -d - -f5 | cut -d . -f1 | sort | uniq
}

if [[ $REGENERATE == true ]]; then

  for size in $(sizes); do
    plotfile=memorytime-$size.dat

    echo Generating $plotfile...

    echo XMI > $plotfile
    cat memory-singlearea-fullhistory-00-$size.xmi/java-0.log \
      | sed -ne 's|^.*MemoryLogger run -- Using \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) MB out of .*|\1\2|p' >> $plotfile

    echo >> $plotfile
    echo >> $plotfile

    echo "TEMF" >> $plotfile
    cat memory-singlearea-nohistory-00-$size.temf/java-0.log \
      | sed -ne 's|^.*MemoryLogger run -- Using \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) MB out of .*|\1\2|p' >> $plotfile
  done

  for size in $(sizes); do
    plotfile=memoryiterations-$size.dat

    echo Generating $plotfile...

    echo XMI > $plotfile
    while read -r line; do
      line2=$line
      ts1=$(echo $line1 | sed -ne 's|^\([[:digit:]]\{4\}-[[:digit:]]\{2\}-[[:digit:]]\{2\} [[:digit:]]\{2\}:[[:digit:]]\{2\}:[[:digit:]]\{2\}\).*|\1|p')
      ts2=$(echo $line2 | sed -ne 's|^\([[:digit:]]\{4\}-[[:digit:]]\{2\}-[[:digit:]]\{2\} [[:digit:]]\{2\}:[[:digit:]]\{2\}:[[:digit:]]\{2\}\).*|\1|p')
      ts1=$(date --date="$ts1" +"%s")
      ts2=$(date --date="$ts2" +"%s")

      if [[ $(( $ts2 - $ts1 )) -lt 10 ]]; then
        if [[ $line1 == *'test.Simulate$MemoryLogger run'*  \
                && $line2 == *'tll.impl.internal.InternalAreaImpl$IterationLogger run'* ]] \
              || [[ $line2 == *'test.Simulate$MemoryLogger run'*  \
                && $line1 == *'tll.impl.internal.InternalAreaImpl$IterationLogger run'* ]]; then
          iteration=$(echo $line1 $line2 | sed -ne 's|.* Running iteration \([[:digit:]]\+\) on .*|\1|p')
          memory=$(echo $line1 $line2 | sed -ne 's|.* Using \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) MB out of .*|\1\2|p')
          if [[ -n $iteration ]] && [[ -n $memory ]]; then
            echo $ts1 $ts2 $iteration $memory >> $plotfile
          fi
        fi
      fi

      line1=$line2
    done < "memory-singlearea-fullhistory-00-$size.xmi/java-1.log"

    echo >> $plotfile
    echo >> $plotfile

    echo TEMF >> $plotfile
    while read -r line; do
      line2=$line
      ts1=$(echo $line1 | sed -ne 's|^\([[:digit:]]\{4\}-[[:digit:]]\{2\}-[[:digit:]]\{2\} [[:digit:]]\{2\}:[[:digit:]]\{2\}:[[:digit:]]\{2\}\).*|\1|p')
      ts2=$(echo $line2 | sed -ne 's|^\([[:digit:]]\{4\}-[[:digit:]]\{2\}-[[:digit:]]\{2\} [[:digit:]]\{2\}:[[:digit:]]\{2\}:[[:digit:]]\{2\}\).*|\1|p')
      ts1=$(date --date="$ts1" +"%s")
      ts2=$(date --date="$ts2" +"%s")

      if [[ $(( $ts2 - $ts1 )) -lt 10 ]]; then
        if [[ $line1 == *'test.Simulate$MemoryLogger run'*  \
                && $line2 == *'tll.impl.internal.InternalAreaImpl$IterationLogger run'* ]] \
              || [[ $line2 == *'test.Simulate$MemoryLogger run'*  \
                && $line1 == *'tll.impl.internal.InternalAreaImpl$IterationLogger run'* ]]; then
          iteration=$(echo $line1 $line2 | sed -ne 's|.* Running iteration \([[:digit:]]\+\) on .*|\1|p')
          memory=$(echo $line1 $line2 | sed -ne 's|.* Using \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) MB out of .*|\1\2|p')
          if [[ -n $iteration ]] && [[ -n $memory ]]; then
            echo $ts1 $ts2 $iteration $memory >> $plotfile
          fi
        fi
      fi

      line1=$line2
    done < "memory-singlearea-nohistory-00-$size.temf/java-1.log"
  done

fi

for plot in $(ls memoryiterations-*.dat); do
iterations=$(echo $plot | cut -d . -f1 | cut -d - -f2)
gnuplot -p << EOF | cat
	set terminal png size 640,480;
	set title "Memory usage";
	set xlabel "Iteration";
	set ylabel "Memory Usage (MB)";
	set format y "%.0f";
	set output "memory-iterations-$iterations.png";
	plot for [IDX=0:1] "$plot" index IDX using 3:4 with lines title columnheader(1);
EOF
done

for plot in $(ls memorytime-*.dat); do
iterations=$(echo $plot | cut -d . -f1 | cut -d - -f2)
gnuplot -p << EOF | cat
	set terminal png size 640,480;
	set title "Memory usage";
	set xlabel "Time";
	set ylabel "Memory Usage (MB)";
	set format y "%.0f";
	set output "memory-time-$iterations.png";
	plot for [IDX=0:1] "$plot" index IDX using 1 with lines title columnheader(1);
EOF
done
