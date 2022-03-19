const fs = require('fs')
let input = fs.readFileSync('/Users/wonjunho/Desktop/junho/Algorithm/Algorithm/javascript/input.txt')
        .toString().trim()

console.log(shock(input))

function shock(input){
    return input+'??!'
}