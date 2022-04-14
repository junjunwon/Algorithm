# 자주 사용되는 내장 함수
result = sum([1,2,3,4])
print(result)

min_result = min(7,3,5,2)
max_result = max(7,3,5,2)
print(min_result, max_result)

#eval()
# 사람의 기준으로 수식으로 표현된 식을 계산해서 수로 반환
result = eval("(3+5)*7")
print(result)

#sorted()
result = sorted([9,1,8,5,4])
reverse_result = sorted([9,1,8,5,4], reverse=True)
print(result)
print(reverse_result)
#sorted() with key
array = [('홍길동', 35), ('이순신', 55), ('아무개', 10)]
result = sorted(array, key=lambda x:x[1] ,reverse=True)
print(result)




data = ['A', 'B', 'C']
from itertools import permutations
result = list(permutations(data, 3)) #모든 순열 구하기
print(result)

from itertools import combinations
result = list(combinations(data, 2)) #2개로 뽑는 조합 구하기.
print(result)

from itertools import product 
result = list(product(data, repeat=2)) #2개를 뽑는 모든 순열 구하기 (중복 허용)
print(result)

from itertools import combinations_with_replacement
result = list(combinations_with_replacement(data, 2)) #2개를 뽑는 모든 조합 구하기(중복 허용)
print(result)

# collections라이브러리의 Counter
from collections import Counter
counter = Counter(['red','blue', 'green', 'blue', 'blue'])
print(counter['blue']) 
print(counter['red'])
print(dict(counter)) # 사전 자료형으로 반환

#math 라이브러리의 최대 공약수(gcd)와 최소 공배수(lcm)
import math

#최소 공배수(LCM)
def lcm(a,b) :
    return a * b // math.gcd(a,b)

a = 21
b = 14
print(math.gcd(21,14)) #최대 공약수 계산
print(lcm(21,14)) #최소 공배수(lcm) 계산