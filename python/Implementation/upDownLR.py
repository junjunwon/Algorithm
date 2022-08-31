# 상하좌우
#여행가 A는 N * N 크기의 정사각형 공간 위에 서 있습니다.
#이 공간은 1 * 1 크기의 정사각형으로 나누어져 있습니다.
# 가장 왼쪽 위 좌표는 (1,1)이며, 가장 오른쪽 아래 좌표는 (N, N)
# 여행가는 상 하 좌 우 방향으로 이동 가능하며 시작 좌표는 항상 (1,1)입니다.
# 계획에에는 하나의 줄에 띄어쓰기를 기준으로 하여 L R U D 중 하나의 문자가 반복적으로 적혀 있습니다.
# L : 왼쪽 한칸 / R : 오른쪽 한칸 / U : 위로 한판 / D : 아래로 한칸 이동
# 이때 여행가 A가 N * N 크기의 정사각형 공간을 벗어나는 움직임은 무시된다.


# 문제 풀이 (풀이 시간 15분 | 시간제한 2초 | 메모리 제한 128MB)
# 1 <= N <= 100   |   1 <= 이동 횟수 <= 100
# 시간복잡도는 어떻게?
# 100,000 -> 2천만안이니까,O(n의 제곱)까지 가능
# 접근 방식
# 1,1부터 
# 입력 : 5 / R R R U D D

# 알고리즘 아이디어
import sys

n = int(input())
data = sys.stdin.readline().rstrip()
print(data[0])

for i in data :
    print(i, end="")

print()
# 동 서 남북
dx = [0, 0, 1, -1]
dy = [1,-1, 0, 0]

cur = [1,1]
pre = [1,1]
for i in data : 
    pre[0] = cur[0]
    pre[1] = cur[1]
    print("i is ", i)
    if i == 'R' :
        print('R 진입!!')
        cur[0] = cur[0] + dx[0]
        cur[1] = cur[1] + dy[0]
    elif i == 'L' :
        print('L 진입!!')
        cur[0] = cur[0] + dx[1]
        cur[1] = cur[1] + dy[1]
    elif i == 'D' :
        print('D 진입!!')
        cur[0] = cur[0] + dx[2]
        cur[1] = cur[1] + dy[2]
    elif i == 'U' :
        print('U 진입!!')
        cur[0] = cur[0] + dx[3]
        cur[1] = cur[1] + dy[3]
    print("pre is ", pre)
    print("cur is ", cur)
    if(cur[0] <=0 or cur[0] >n or cur[1] <=0 or cur[1] > n) :
        print("범위 밖!!")
        cur = pre

print()
print(cur[0],cur[1])

# 동빈나 풀이
n = int(input())
x, y = 1, 1
plans = input().split()

dx = [0,0,-1,1]
dy = [-1,1,0,0]
move_types = ['L', 'R', 'U', 'D']

for plan in plans :
    for i in range(len(move_types)) :
        if plan == move_types[i] :
            nx = x + dx[i]
            ny = y + dy[i]
    #공간을 벗어나는 경우 무시
    if(nx < 1 or ny < 1 or nx > n or ny > n) :
        continue
    x, y = nx, ny

print(x, y)
##nx, ny를 초기화하지 않아도, for문 밖에서 사용이 가능하다.
 