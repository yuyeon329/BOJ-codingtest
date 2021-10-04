if __name__ == '__main__':
    s1 = input()
    s2 = input()
    tmp = max(len(s1), len(s2))

    s1 = '.'*(tmp+1-len(s1)) + s1
    s2 = '.'*(tmp+1-len(s2)) + s2

    dp = [[0 for _ in range(len(s1)+1)] for _ in range(len(s2)+1)]

    for i in range(len(s1)):
        dp[0][i+1] = s1[i]

    for j in range(len(s2)):
        dp[j+1][0] = s2[j]

    for i in range(1, len(s1)):
        dp[1][i] = 0

    for j in range(1, len(s2)):
        dp[i][1] = 0

    for i in range(2, len(s1)+1):
        for j in range(2, len(s2)+1):
            if dp[i][j-j] == dp[i-i][j]:
                dp[i][j] = dp[i-1][j-1]+1
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    print(max(dp[len(s2)][1:]))
