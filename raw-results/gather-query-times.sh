#! /bin/bash

REGENERATE=false

function sizes() {
  ls -d memory-singlearea-fullhistory-00-*.xmi | cut -d - -f5 | cut -d . -f1 | sort | uniq
}

plotfile=querytime.dat

if [[ $REGENERATE == true ]]; then

  echo Generating $plotfile...

  echo 'XMI'  > $plotfile

  for size in $(sizes); do

    while read -r line; do
      if [[ $line == *'Q0 - Number'* ]]; then
        read qline
        q1=$(echo $qline | sed -ne 's|.* \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) ms.*|\1\2|p')
      fi
      if [[ $line == *'Q1 - Number'* ]]; then
        read qline
        q2=$(echo $qline | sed -ne 's|.* \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) ms.*|\1\2|p')
      fi
      if [[ $line == *'Q2 - Number'* ]]; then
        read qline
        q3=$(echo $qline | sed -ne 's|.* \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) ms.*|\1\2|p')
      fi
      if [[ $line == *'Q3 - Utilization'* ]]; then
        read qline
        q4=$(echo $qline | sed -ne 's|.* \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) ms.*|\1\2|p')
      fi
    done < "memory-singlearea-fullhistory-00-$size.xmi/execution.log"

    
    if [ -z $q1 ]; then
          q1=!
    fi
    if [ -z $q2 ]; then
          q2=!
    fi
    if [ -z $q3 ]; then
          q3=!
    fi
    if [ -z $q4 ]; then
          q4=!
    fi

    echo $size $q1 $q2 $q3 $q4 >> $plotfile
    unset q1 q2 q3 q4
  done

  echo >> $plotfile
  echo >> $plotfile

  echo 'TEMF' >> $plotfile
  
  for size in $(sizes); do
    while read -r line; do
      if [[ $line == *'Q0 - Number'* ]]; then
        read qline
        q1=$(echo $qline | sed -ne 's|.* \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) ms.*|\1\2|p')
      fi
      if [[ $line == *'Q1 - Number'* ]]; then
        read qline
        q2=$(echo $qline | sed -ne 's|.* \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) ms.*|\1\2|p')
      fi
      if [[ $line == *'Q2 - Number'* ]]; then
        read qline
        q3=$(echo $qline | sed -ne 's|.* \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) ms.*|\1\2|p')
      fi
      if [[ $line == *'Q3 - Utilization'* ]]; then
        read qline
        q4=$(echo $qline | sed -ne 's|.* \([[:digit:]]\+\)\?,\?\([[:digit:]]\+\) ms.*|\1\2|p')
      fi
    done < "memory-singlearea-nohistory-00-$size.temf/execution.log"


    if [ -z $q1 ]; then
          q1=!
    fi
    if [ -z $q2 ]; then
          q2=!
    fi
    if [ -z $q3 ]; then
          q3=!
    fi
    if [ -z $q4 ]; then
          q4=!
    fi
    
    echo $size $q1 $q2 $q3 $q4 >> $plotfile
    unset q1 q2 q3 q4
  done
fi

