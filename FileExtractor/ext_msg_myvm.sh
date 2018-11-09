#!/usr/bin/env bash
echo "------------------ Making Report -----------------"
find . -name "*.txt" | xargs grep $1 > report_$1.res

echo "------------------ Copy Dependency File -----------------"
mkdir RES_FILES_$1
copy_file_myvm.sh RES_FILES_$1 < report_$1.res
