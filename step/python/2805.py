import sys
if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().split())
    tree = list(map(int, sys.stdin.readline().split()))
    start = 0
    end = max(tree)

    while start <= end:
        mid = (start+end)//2
        cnt = 0

        cnt = sum(t - mid if t > mid else 0 for t in tree)

        if cnt < M:
            end = mid - 1
        else:
            start = mid + 1

    print(end)
