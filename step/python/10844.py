if __name__ == '__main__':
    answer = 0
    N = int(input())
    dp = [[0 for i in range(10)] for j in range(N)]

    for i in range(N):
        for j in range(10):
            if i == 0 and j:
                dp[i][j] = 1
            else:
                if i:
                    if j == 0:
                        dp[i][j] = dp[i-1][1]
                    elif j == 9:
                        dp[i][j] = dp[i-1][8]
                    else:
                        dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])

    for i in range(10):
        answer += dp[N-1][i]
    print(answer % 1000000000)


