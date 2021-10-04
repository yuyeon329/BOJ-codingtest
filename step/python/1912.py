if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    dp = [0 for _ in range(n)]
    dp[0] = arr[0]
    for i in range(1, n):
        if dp[i-1]+arr[i] <= arr[i]:
            dp[i] = arr[i]
        else:
            dp[i] = dp[i-1]+arr[i]
    print(dp)
    print(max(dp))