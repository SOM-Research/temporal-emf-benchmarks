#! /bin/bash

REGENERATE=false

function delays() {
  ls -d singlearea-*-*-*.xmi | cut -d - -f3 | sort | uniq
}

function sizes() {
  ls -d singlearea-*-*-*.xmi | cut -d - -f4 | cut -d . -f1 | sort | uniq
}

if [[ $REGENERATE == true ]]; then
	for size in $(sizes); do
		plotfile=time-$size.dat
		echo XMI > $plotfile
		for delay in $(delays); do
			time=$(cat singlearea-fullhistory-$delay-$size.xmi/execution.log | sed -ne 's|^[[:space:]]\+\[java\] Total time: \([[:digit:]]\+\)|\1|p')
			echo $delay $time >> $plotfile
		done
		echo >> $plotfile
		echo >> $plotfile
		echo TEMF >> $plotfile
		for delay in $(delays); do
			time=$(cat singlearea-nohistory-$delay-$size.temf/execution.log | sed -ne 's|^[[:space:]]\+\[java\] Total time: \([[:digit:]]\+\)|\1|p')
			echo $delay $time >> $plotfile
		done
	done
fi
	
for plot in $(ls *.dat); do
iterations=$(echo $plot | cut -d . -f1 | cut -d - -f2)
gnuplot -p << EOF | cat
	set terminal png size 400,300;
	set title "$iterations iterations";
	set xlabel "Thinking time (ms)";
	set ylabel "Processing time (ms)";
	set format y "%.0f";
	set output "time-$iterations-linear.png";
	plot for [IDX=0:1] "$plot" i IDX u 1:(\$2/1000) smooth csplines title columnheader(1);
	set logscale y 2;
	set output "time-$iterations-log2.png";
	replot;
EOF
done