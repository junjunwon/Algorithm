// console.log(process.cwd()) //find absolute path
const fs = require('fs')
let input = fs.readFileSync('/Users/wonjunho/Desktop/junho/Algorithm/Algorithm/javascript/input.txt').toString().split(' ')
// console.log(input)

function add(input) {
    return (+input[0])+(+input[1]) //string 앞에 +를 붙이고 연산할 경우 number 변환됨. 
}

console.log(add(input))