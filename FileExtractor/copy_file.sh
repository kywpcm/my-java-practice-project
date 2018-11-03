#!/usr/bin/env bash
while IFS= read -r LINE
do
  SRC_FILE=`awk '{
      offset=match($0,":") - 1;
      print substr($0,0,offset);
  }'`
  cp -u $SRC_FILE $1
done
