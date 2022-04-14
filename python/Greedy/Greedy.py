#거스름돈  : 시간 복잡도 분석
# 화폐의 종류가 K일 때 시간복잡도 : O(K) -> 동전의 총 종류에만 영향을 받는다.
n = 1260

count = 0

array = [500, 100, 50, 10]

for coin in array :
    count += n // coin #해당 화폐로 거슬러 줄 수 있는 동전의 수 세기
    n %= coin

print(count)

##1이 될 때까지
# 주어진 N에 대하여 최대한 많이 나누기를 수행.
# N의 값을 줄일때 2 이상의 수로 나누는 작업이 1을 빼는 작업보다 수를 많이 줄일 수 있다.
# 정당성 분석
# 가능하면 최대한 많이 나누는 작업이 최적의 해를 항상 보장할 수 이쓴ㄴ가?
# N이 아무리 큰 수여도 K로 계속 나눈다면 기하급수적으로 빠르게 줄일 수 있다.
# 즉 K가 2이상이기만 하면, K로 나누는 것이 1을 배는 것보다 항상 빠르게 N을 줄일 수 있다는 것은 자명하다.
N,K = map(int, input().split())
count = 0
while N!=1 :
    if N % K == 0 :
        print('나머지가 0일때 ',N)
        N = N // K
        count += 1
    else :
        print('나머지가 0이 아닐때 ',N)
        N -=1
        count +=1
print(count)

#동빈나 강사님 코드 구현법
#시간 복잡도 : 로그시간 복잡도
result = 0
n,k = map(int, input().split())
while True :
    #N이 K로 나누어 떨어지는 수가 될때까지 빼기 (25, 3)
    target = (n // k) * k  #나누어떨어지지 않을때 가장 가까운 타겟을 구할 수 있다.
    result += (n - target) # 나누어떨어지면 +0, 나누어떨어지지 않으면 +1 
    n = target
    if n<k:
        break
    result +=1
    n //=k

