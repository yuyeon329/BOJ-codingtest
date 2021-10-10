if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    arr = sorted(arr)

    answer = 0

    for i in range(N):
        tmp = 0
        for j in range(i+1):
            tmp += arr[j]
        answer += tmp

    print(answer)
