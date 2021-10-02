import sys
def tile(N):
    if N <= 2:
        return N
    else:
        arr = [0, 1, 2] + [0] * (N - 2)
        for i in range(3, N+1):
            arr[i] = (arr[i-1] + arr[i-2])%15746
    return arr[N]

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    print(tile(N))

