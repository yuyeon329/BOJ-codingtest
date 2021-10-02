import sys
if __name__ == '__main__':
    score = [0]*300
    dp = [0]*300
    n = int(input())


    for i in range(n):
        score[i] = (int(sys.stdin.readline()))

    dp[0] = score[0]
    dp[1] = score[0]+score[1]
    dp[2] = max(score[2]+score[0], score[2]+score[1])
    for i in range(3, n):
        dp[i] = max(dp[i-3]+score[i-1]+score[i], dp[i-2]+score[i])

    print(dp[n-1])