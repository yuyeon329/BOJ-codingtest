def tri(N):
    if N <= 3:
        return 1
    else:
        arr = [1, 1, 1] + [0] * (N - 2)
        for i in range(3, N+1):
            arr[i] = arr[i-2] + arr[i-3]
        return arr[N-1]

if __name__ == '__main__':
    T = int(input())
    for _ in range(T):
        N = int(input())
        print(tri(N))