#!/usr/bin/env bash
# 특정 문자열 라인 포함한 원본 파일 복사
find . -name "*.txt" -exec grep -l "홍길동" '{}' \; | awk '{print "cp "$0" ../out/source_file_list/"}' | sh

# 특정 문자열 라인(파일명 + 문자열) 추출해서 하나의 파일로 생성
find . -name "*.txt" | xargs grep "홍길동" > ../out/out.txt
