import sys
if __name__ == '__main__':
    N, K = map(int, sys.stdin.readline().split())
    arr = [[0 for _ in range(N+1)] for _ in range(N+1)]

    for i in range(N+1):
        for j in range(N+1):
            if j == 0:
                arr[i][j] = 1
            else:
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j]

    print(arr[N][K]%10007)