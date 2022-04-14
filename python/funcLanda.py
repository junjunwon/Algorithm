#함수란 
# 특정한 작업을 하나로 묶어 놓은 것
# 불필요한 소스코드의 반복을 줄일 수 있다.

#함수의 종류
# 내장함수 : 파이썬이 기본적으로 제공하는 함수
# ex) input, print() 등
# 사용자 정의 함수 : 개발자가 직접 정의하여 사용할 수 있는 함수

#함수 정의하기
# 매개변수 : 함수 내부에서 사용할 변수
# 반환 값 : 함수에서 처리된 결과를 반환

# def 함수명(매개변수):
#     실행할 소스코드
#     return 반환 값
def add(a,b) :
    return a+b

result = add(1,2)
print(result)

# 중요한 부분!!
# 파이썬은 파라미터의 변수를 직접 지정할 수 있다
## 이 경우 매개변수의 순서가 달라도 상관이 없다.

result = add(b=2, a=1)
print(result)

# global 키워드
# global 키워드로 변수를 지정하면 해당 함수에서는 지역 변수를 만들지 않고, 함수 바깥에 선언된 변수를 바로 참조하게 된다.
a = 0
def func() :
    global a
    a+=1

for i in range(10) :
    func()

print(a)

# 지역변수에 아래처럼 같은 array리스트가 없을 경우 global을 선언하지 않아도, global 변수 array에 값을 append해줄 수 있다.
# 하지만 동일한 이름의 지역변수가 있을 경우 지역변수를 우선적으로 할당한다.
## 추가로 코딩테스트에서는 리스트를 전역에 선언해놓고 사용하는 경우가 많고, 함수와 동일한 리스트 명을 넣는 경우가 거의 없기 때문에 굳이 global을 하지 않아도 스코프 문제가 발생하진 않는다.

array = [1,2,3,4,5]
def func2() :
    #gloal array 로 선언하고 사용 가능.
    array = [3,4,5]
    array.append(6)
    print(array)
func2()
print(array)

##함수는 여러개의 반환 값을 가질 수 있다 -> 패킹이라고도 한다. (별표!)
def operator(a,b) :
    add_var = a+b
    subtract_var = a-b
    multiply_var = a*b
    divide_var= a/b
    return add_var, subtract_var, multiply_var, divide_var #반환하고자 하는 변수들이 한꺼번에 반환되는 것을 패킹이라고 한다.

a,b,c,d = operator(7,3) #반환된 값을 차례대로 특정 변수에 담는 것을 언패킹이라고 한다.
print(a,b,c,d)



#람다 표현식 - 함수를 간단하게 작성 가능
# 특정한 기능을 수행하는 함수를 한 줄에 작성할 수 있다는 점이 특징이다.
print((lambda a,b: a+b)(3,7))
#(lambda를 이용한 add함수)(파라미터)
#어떠한 함수 자체를 입력으로 받은 또다른 함수를 작성할때 사용?
#한번 사용하고 말 경우에 효과적으로 사용
#정렬 함수 등. (굉장히 많이 사용!!)

array = [('홍길동', 50), ('이순신', 32), ('아무개', 74)]
def my_key(x):
    return x[1] #두번째 원소를 기준으로 return
print(sorted(array, key=my_key))
print(sorted(array, key=lambda x:x[1]))

##여러개의 리스트에 동일한 규칙을 가지는 하나의 함수를 만들때
#map은 각각의 원소에 어떠한 함수를 적용하려고 할때 유용하게 사용한다.
list1= [1,2,3,4,5]
list2 = [6,7,8,9,10]
result = map(lambda a,b:a+b, list1, list2)

print(list(result))