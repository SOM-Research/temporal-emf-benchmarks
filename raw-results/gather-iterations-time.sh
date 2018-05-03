#! /bin/bash

REGENERATE=false

function sizes() {
  ls -d memory-singlearea-fullhistory-00-*.xmi | cut -d - -f5 | cut -d . -f1 | sort | uniq
}

period=20

if [[ $REGENERATE == true ]]; then

  for size in $(sizes); do
    plotfile=iterationstime-$size.dat

    echo Generating $plotfile...

    echo XMI > $plotfile
    while read -r line; do
      if [[ $line == *'tll.impl.internal.InternalAreaImpl$IterationLogger run'* ]]; then
        iteration=$(echo $line | sed -ne 's|.* Running iteration \([[:digit:]]\+\) on .*|\1|p')
        if [[ -n $iteration ]] && [[ -n $lastiteration ]]; then
          echo $(( ( $iteration - $lastiteration ) / $period )) >> $plotfile
        fi
      fi
      lastiteration=$iteration
    done < "memory-singlearea-fullhistory-00-$size.xmi/java-1.log"

    echo >> $plotfile
    echo >> $plotfile

    echo TEMF >> $plotfile

    while read -r line; do
      if [[ $line == *'tll.impl.internal.InternalAreaImpl$IterationLogger run'* ]]; then
        iteration=$(echo $line | sed -ne 's|.* Running iteration \([[:digit:]]\+\) on .*|\1|p')
        if [[ -n $iteration ]] && [[ -n $lastiteration ]]; then
          echo $(( ( $iteration - $lastiteration ) / $period )) >> $plotfile
        fi
      fi
      lastiteration=$iteration
      done < "memory-singlearea-nohistory-00-$size.temf/java-1.log"
  done

fi

for plot in $(ls iterationstime-*.dat); do
iterations=$(echo $plot | cut -d . -f1 | cut -d - -f2)
gnuplot -p << EOF | cat
	set terminal png size 640,480;
	set title "Throughput";
	set xlabel "Time";
	set ylabel "Iterations per unit of time";
	set format y "%.0f";
	set output "iterations-time-$iterations.png";
	plot for [IDX=0:1] "$plot" index IDX using 1 with lines title columnheader(1);
EOF
done
