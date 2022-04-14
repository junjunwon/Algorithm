## 기본 입력
# n = 5
# 65 90 75 34 99

#자주 사용되는 표준 입력 방법
#input()함수는 한 줄의 문자열을 입력받는 함수
# map() 함수는 리스트의 모든 원소에 각각 특정한 함수를 적용할 때 사용한다.
# 예시) 공백을 기준으로 구분된 데이터를 입력받을 때 다음과 같이 사용한다.
# list(map(int, iput().split()))
# 예시) 공백을 기준으로 구분된 데이터의 개수가 많지 않다면, 단순히 다음과 같이 사용한다.
# a, b, c = map(int, input().split())

#사용자로부터 빠르게 입력받아야 하는 경우
## 파이썬의 경우 sys 라이브러리에 정의되어 있는 sys.stdin.readline()메서드를 이용한다.
## 단 입력 후 엔터(Enter)가 줄 바꿈 기호로 입력되므로 rstrip()메서드를 함께 사용한다.
## 이진 탐색, 정렬, 그래프 관련 문제에서 자주 사용하는 테크닉
import sys
#문자열 입력 받기
data = sys.stdin.readline().rstrip()
print(data)
#데이터의 개수 입력
n = int(input())
#각 데이터를 공백을 기준으로 구분하여 입력
data = list(map(int, input().split()))
 
data.sort(reverse=True)
print(data)