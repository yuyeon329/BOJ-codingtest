import sys

if __name__ == '__main__':
    tri = []
    n = int(input())
    for i in range(n):
        tri.append(list(map(int, sys.stdin.readline().split())))

    for i in range(n-2, -1, -1):
        for j in range(i+1):
            tri[i][j] = max(tri[i+1][j], tri[i+1][j+1]) + tri[i][j]

    print(tri[0][0])

