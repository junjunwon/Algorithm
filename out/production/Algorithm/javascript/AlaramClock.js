"use strict"
/**
 * 45분 일찍 알람 설정하기.
 * 정수 H, M (0<=H<=23, 0<=M<=59)
 * H시 M분
 * 
 * 하루의 시작은 0:0(자정)
 * 끝은 23:59(다음날 자정 1분 전)
 * 시간을 나타낼때 불필요한 0은 사용하지 않는다.
 * 
 * 주의할 점
 * 00시 44분일 경우까지는 전날로 넘어간다.
 * 00시일때 M<45일 경우 H = 23으로 변경
 * 
 * 나머지는 
 * M>=45일때 M=M-45 
 * M<45일때 M=45-M
 *  H=H-1
 */

const fs = require('fs')
let input = fs.readFileSync('/Users/wonjunho/Desktop/junho/Algorithm/Algorithm/javascript/input.txt').toString().split(' ')

