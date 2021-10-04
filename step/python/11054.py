import sys
if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, sys.stdin.readline().split()))
    dp_asc = [0 for _ in range(N)]
    dp_desc = [0 for _ in range(N)]
    dp_binary = [0 for _ in range(N)]

    for i in range(N):
        for j in range(i):
            if arr[j] < arr[i] and dp_asc[i] <= dp_asc[j] :
                dp_asc[i] = dp_asc[j]
        dp_asc[i] += 1

    for i in range(N-1, -1, -1):
        for j in range(N-1, i, -1):
            if arr[j] < arr[i] and dp_desc[i] <= dp_desc[j]:
                dp_desc[i] = dp_desc[j]
        dp_desc[i] += 1

    for i in range(N):
        dp_binary[i] = dp_asc[i]+dp_desc[i]-1

    print(max(dp_binary))
