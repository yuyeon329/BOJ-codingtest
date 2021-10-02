import sys
if __name__ == '__main__':
    N = int(input())
    arr = [[0]*3 for i in range(N)]
    for i in range(N):
        arr[i][0], arr[i][1], arr[i][2] = map(int, sys.stdin.readline().split())

    for i in range(1, N):
        arr[i][0] = min(arr[i-1][1], arr[i-1][2]) + arr[i][0]
        arr[i][1] = min(arr[i-1][0], arr[i-1][2]) + arr[i][1]
        arr[i][2] = min(arr[i-1][0], arr[i-1][1]) + arr[i][2]

    print(min(arr[N-1][0], arr[N-1][1], arr[N-1][2]))
