import sys

N = int(sys.stdin.readline())
arr = list()

for _ in range(N):
    r, c = map(int, sys.stdin.readline().split())
    arr.append((r, c))

dp = [[0]*N for _ in range(N)]
"""
점화식
cost(M1x...xMn) = cost(M1x...xMi) + cost(Mi+1x...xMn) + p1*pi+1+1*pn+1
dp[1][n] = 행렬1~행렬n까지의 최소 cost
"""

for i in range(1, N):
    for j in range(N-i):
        x = i+j
        if i == 1:
            dp[j][x] = arr[j][0]*arr[x][0]*arr[x][1]
            continue

        dp[j][x] = 2**32
        for k in range(j, x):
            dp[j][x] = min(dp[j][x], dp[j][k]+dp[k+1][x]+arr[j][0]*arr[k][1]*arr[x][1])

print(dp[0][N-1])
