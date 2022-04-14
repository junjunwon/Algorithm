# python의 list 는 c++의 벡터 리스트, java 의 arraylist등을 지원한다.
# 정수형
# 양의 정수
from re import M


a = 1000
print(a)

#음의 정수
a= -7
print(a)

#0
a = 0
print(a)

##실수형
# 소수점 아래의 데이터를 포함하는 수 자료형
# 소수부가 0이거나 정수부가 0인 소수는 0을 생략하고 작성도 가능하다.
#양의 실수
a=157.93
print(a)
#음의 실수
a=-1833.2
print(a)

#소수부가 0일 때 0을 생략
a = 5.
print(a)

#정수부가 0일 때 0을 생략
a = -.7
print(a)

# 지수 표현 방식
a=1e9
print(a)

#752.5
a = 75.25e1
print(a)

#3.954
a = 3954e-3
print(a)

#실수 데이터로 인한 오류 방지
#실수 연산 오차로 인한 오류또한 어느정도 예방 가능하다.
a = int(1e9)
print(a)

#실수 오차 예제
a = 0.3 + 0.6
print(a)
if a==0.9:
    print(True)
else :
    print(False)

##수 자료형 연산
a = 7
b = 3
#divide
print (a / b)
#나머지
print(a % b)
#몫
print( a // b)
#거듭 제곱
print(a ** b)
#제곱근
print(a ** 0.5)


# 리스트 초기화
#직접 데이터를 넣어 초기화
a = [1,2,3,4,5,6,7,8,9]
print(a)

#네 번째 원소만 출력
print(a[3])
#크기가 N이고 모든 값이 0인 1차원 리스트 초기화
n = 10
a = [0] * n
print(a)
#여덟 번째 원소만 출력
print(a[7])
#뒤에서 첫 번째 원소 출력
print(a[-1])
## 두번째 원소부터 네번째 원소까지
print(a[1 : 4])
#리스트 컴프리헨션
#range = 0-n범위까지 차례로 순회
array = [i for i in range(10)]
print(array)
print(range(10))
# 0부터 19까지 수 중에서 홀수만 포함하는 리스트
array = [i for i in range(20) if i % 2 ==1]
print(array)
## 일반적인 코드
array = []
for  i in range(20):
    if i % 2 == 1 :
        array.append(i)

print(array)
#1부터 9까지의 수들의 제곱 값을 포함하는 리스트
array = [i * i for i in range(1, 10)]
print(a)
#리스트 컴프리헨션 (잘못된 예시)
# N * M 크기의 2차원 리스트 초기화 (잘못된 방법)
n = 4
m = 3
array = [[0] * m ] * n
print(array)
array[1][1] = 5
print(array)

#언더바 사용
for _ in range(5):
    print("hello world")

# 리스트 메서드
a = [1, 4, 3]
print(a)
#원소 삽입
a.append(2)
print(a)
#오름차순
a.sort()
print(a)
#내림차순
a.sort(reverse=True)
print(a)
#원소 뒤집기
a.reverse()
print(a)
#특정 인덱스에 데이터 추가
a.insert(2,3)
print(a)
#특정 값인 데이터 개수 세기
a.count(3)
print(a)
#특정 값 데이터 삭제
a.remove(1)
print(a)
#리스트에서 특정 값을 가지는 원소를 모두 제거하기.
a = [1,2,3,4,5,5,5]
remove_list = {3,5} #집합 자료형

#remove_list에 포함되지 않은 값만을 저장
result = [i for i in a if i not in remove_list]
print(result)

# 문자열 자료형
data = 'hello world'
print(data)

data = "Dont you know \"Pyton\"";
print(data)

# 문자열 연산
a = "Hello"
b = "world"
print(a + " " + b)
a = "String"
print(a * 3)

a = "ABCDEF"
print(a[2:4])
# a[2] = 'b' #원소 할당은 지원하지 않는다. 변경 불가능한 객체이기 때문

# 튜플
a = (1,2,3,4,5,6,7,8,9)
#네번 째 원소만 출력
print(a[3])
#두 번째 원소부터 네 번째 원소까지
print(a[1:4])
# a[2] = 7 #튜플은 변경 불가능한 객체 

##사전 자료형 Hash Table
data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'

print(data)
if '사과' in data:
    print("'사과에 해당하는 값이 있다.")

#키 데이터만 담은 리스트
key_list=list(data.keys())
print(key_list)
#값 데이터만 담은 리스트
value_list=(data.values())
print(value_list)
#각 키에 따른 값을 하나씩 출력
for key in key_list :
    print(data[key])

#집합 자료형
data = set([1,1,2,3,4,4,5]) #중복은 제거
print(data)
data = {1,1,2,3,4,4,5} #중괄호는 set과 동일한 집합 자료형 
print(data)

a = set([1,2,3,4,5])
b = set([3,4,5,6,7])

#합집합
print(a|b)
#교집합
print(a&b)
#차집합
print(a-b)
data = set([1,2,3])
#새로운 원소 추가
data.add(4)
print(data)
#새로운 원소 여러 개 추가
data.update([5,6])
print(data)
#특정한 값을 갖는 원소 삭제
data.remove(3)
print(data)