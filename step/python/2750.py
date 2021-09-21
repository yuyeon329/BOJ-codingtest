if __name__ == '__main__':
    N = int(input())
    arr = []
    for _ in range(N):
        arr.append(int(input()))

    for i in range(N):
        for j in range(N-1-i):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
    for i in arr:
        print(i)
