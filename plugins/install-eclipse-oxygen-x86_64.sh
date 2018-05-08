#!/bin/bash

source "${0%/*}/_install-eclipse-linux.sh" \
  -u "http://archive.eclipse.org/eclipse/downloads/drops4/R-4.7.3a-201803300640/eclipse-SDK-4.7.3a-linux-gtk-x86_64.tar.gz" \
  -v "oxygen" \
  -f org.apache.hadoop.hbase.feature.feature.group,io.github.abelgomez.klyo.feature.feature.group,org.eclipse.emf.sdk.feature.group
