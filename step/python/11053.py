if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    dp = [0 for _ in range(N)]
    for i in range(N):
        for j in range(i):
            if arr[j] < arr[i] and dp[i] <= dp[j]:
                dp[i] = dp[j]
        dp[i] += 1

    print(max(dp))
