import sys
if __name__ == '__main__':
    wine = [0]
    n = int(input())
    for _ in range(n):
        wine.append(int(sys.stdin.readline()))

    dp = [0]
    dp.append(wine[1])
    if n>1:
        dp.append(wine[1]+wine[2])

    for i in range(3, n+1):
        dp.append(max(dp[i-2]+wine[i], dp[i-3]+wine[i-1]+wine[i], dp[i-1]))

    print(dp[n])
