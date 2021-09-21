import sys
if __name__ == '__main__':
    N = int(input())
    arr = [0] * 10001
    for i in range(N):
        n = int(sys.stdin.readline())
        arr[n] += 1

    for i in range(10001):
        if arr[i]:
            for j in range(arr[i]):
                print(i)