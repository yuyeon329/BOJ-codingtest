import sys
if __name__ == '__main__':
    K, N = map(int, input().split())
    lan = [int(sys.stdin.readline()) for _ in range(K)]
    e = max(lan)
    s = 1

    while s <= e:
        m = (s+e)//2
        cnt = 0
        for i in lan:
            cnt += i//m
        if cnt >= N:
            s = m + 1
        else:
            e = m - 1

    print(e)


