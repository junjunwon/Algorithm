# 자주 사용되는 표준 출력 방법
# 파이썬에서 기본 출력은 print() 함수를 이용
# 각 변수를 콤마(,)를 이용하여 띄어쓰기로 구분하여 출력할 수 있다.
# print()는 기본적으로 출력 이후에 줄 바꿈을 수행한다.
# 줄 바꿈을 원치 않는 경우 'end' 속성을 이용하면 된다.
#입력관련 부분은 basicinput 참고
a = 1
b = 2
print(a,b)
print(7, end=" ")
print(8, end=" ")
answer = 7
print("정답은 " + str(answer) + "입니다.")

#f-string (up to python 3.6 available)
#중괄호 안에 변수명을 기입하여 간단히 문자열과 정수를 함께 넣을 수 있다.
#수 데이터를 문자열로 변환해주지 않아도 되는 장점!
answer = 7
print(f"정답은 {answer}입니다.")

