import sys

n, k = map(int, sys.stdin.readline().split())
data = list()

for _ in range(n):
    data.append(int(sys.stdin.readline()))

data.sort()

dp = [1]+[0]*k

#점화식 = dp[n] = dp[n-현재 동전의 가치] + 직전 동전 구성으로 만든 n
#n-현재 동전의 가치 = 현재동전은 이미 만들어진 값에 숟가락만 얹음

for i in data:
    for j in range(i, k+1):
        if j-i >= 0:
            dp[j] = dp[j-i] + dp[j]

print(dp[k])