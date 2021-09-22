import sys
if __name__ == '__main__':
    N = int(input())
    arr = []
    for _ in range(N):
        tmp = list(sys.stdin.readline().split())
        arr.append(tmp)

    arr.sort(key=lambda x: int(x[0]))

    for i in arr:
        print(i[0], i[1])