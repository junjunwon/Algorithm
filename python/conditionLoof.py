x = 15
if x>10:
    print("x >10")

#들여쓰기
#파이썬에서는 코드의 블록(Block)을 들여쓰기(Indent)로 지정한다.
#현재 파이썬 스타일 가이드라인에서 4개의 공백 문자를 사용하는 것을 표준으로 설정하고 있다.
#condition
#if ~ elif ~ else

a = -3
if a>= 0 :
    print("a>=0")
elif a>= -10:
    print("0 >a >= -10")
else :
    print("-10>a")

# 논리 연산자 : 논리 값 (True / False)
# 자바와 다르게 직관적으로 코드 작성
# 모두 참 : X and Y
# 둘 중 하나만 참 : X or Y
# X가 거짓일 때 참 : not X

a = 15
if a<=20 and a>=0 :
    print("True")  


#기타 연산자
#다수의 데이터를 담은 자료형을 위해 in 연산자와 not in 연산자가 제공된다.
# 리스트, 튜플, 문자열, 딕셔너리 모두에서 사용이 가능하다.
# x in 리스트 : 리스트 안에 x가 들어가 있을 때 참이다.
# x not in 문자열 : 문자열 안에 x가 들어가 있지 않을때 참이다.

## pass 키워드 : 아무것도 처리하고 싶지 않을때
## 코드를 나중에 작성하고 싶을때 예외처리 같은것.
score = 20
if score >=30: 
    pass
else : 
    print("a<30")

#조건 부 표현식(Conditional Expression)은 if -else문을 한 줄에 작성
score = 85
result = "Success" if score >= 80 else "Fail"
print(result)

# 조건문 내에서의 부등식
# 다른 언어와 다르게 수학 부등식을 그대로 사용 가능
# 예를 들어 0 < x < 20을 그대로 사용할 수 있다.
# 다른 언어를 사용할 때 헤깔릴 수 있기 때문에 주의해야 한다.
x = 15
if 0 < x < 20 :
    print("x는 0 이상 20 미만의 수이다.")

#반복문
#python 은 while과 for문이 있다. 
#but for문이 간결한 경우가 많다.

#while
i = 1
result = 0
#i가 9보다 작거나 같을 때 아래 코드를 반복적으로 실행
while i<=9:
    result += i
    i +=1
print(result)

#for문
#튜플, 리스트 사용 가능. 
result = 0
#range를 쓸 경우 range(시작 값, 끝 값+1)형태로 인자를 하나만 넣으면시작 값은 0이 된다.
for i in range(1,10) :
    result+=i
print(result)

array = [9,8,7,6,5]
for x in array :
    print(x)
#무한루트
#코딩테스트는 무한 루프를 구현할 일은 없으니 break를 잘 걸고 있는지 확인해야 한다.

# 반복문 continue 키워드
# 1부터 9까지 홀수의 합을 구할때
result = 0
for i in range(1,10) :
    if(i % 2 == 0) :
        continue
    result += i
print(result)

# break 키워드
# 반복문을 즉시 탈출하고자 할때
# 1-5까지의 정수를 차례대로 출력하고자 할 경우
i = 1
while True:
    print('현재 값 :', i)
    if i==5 :
        break
    i+=1

#학생들의 합격 여부 판단 예제 1) 점수가 80점만 넘으면 합격
scores = [90,85,77,65,97]

for i in scores :
    if(i>=80):
        print(i)

for i in range(5) :
    if(scores[i]>=80) :
        print(i+1,"번 학생은 합격입니다.")

#2)특정 번호의 학생은 제외하기.
cheating_student_list = {2,4}
for i in range(5) :
    if i + 1 in cheating_student_list :
        continue
    if scores[i] >= 80 :
        print(i+1,"번 학생은 합격입니다.")

#이중포문(중첩된 반복문)
##구구단 예제
for i in range(2,10) :
    for j in range(1, 10):
        print(i, "X", j, "=", i*j)
    print()

    