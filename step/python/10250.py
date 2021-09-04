if __name__ == '__main__':
    T = int(input())
    for _ in range(T):
        H, W, N = map(int, input().split())
        floor = N % H if N % H else H
        arc = N//H+1 if N % H else N//H
        print('{0:01d}{1:02d}'.format(floor, arc))
