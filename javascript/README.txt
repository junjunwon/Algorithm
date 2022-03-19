"use strict" 사용
-  기존에는 조용히 무시되던 에러들을 throwing하고, 엔진의 최적화 작업을 어렵게 만드는 실수들을 바로잡아, 
- 가끔씩 strict mode의 코드는 non-strict mode의 동일한 코드보다 더 빨리 작동

백준 사이트에 입력 받을떄 input 
let input = fs.readFileSync('/dev/stdin').toString().split(' ');

테스트 데이터는 input.txt 파일에서 받아오기
- 받아올때는 항상 절대경로로
    - 절대 경로 확인법 = console.log(process.cwd()) 
let input = fs.readFileSync('/Users/wonjunho/Desktop/junho/Algorithm/Algorithm/javascript/input.txt').toString()

string -> number
1. Number(string variable) --> Number('3')
2. +(string Variable) --> 3 = (+'1')+(+'2')