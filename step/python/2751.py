import sys
if __name__ == '__main__':
    N = int(input())
    arr = []
    for _ in range(N):
        arr.append(int(sys.stdin.readline()))
    for i in sorted(arr):
        print(i)