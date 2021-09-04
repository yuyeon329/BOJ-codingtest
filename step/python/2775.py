if __name__ == '__main__':
    T = int(input())
    for _ in range(T):
        k = int(input())
        n = int(input())
        floor_0 = [i for i in range(1, n+1)]
        for i in range(k):
            for j in range(1, n):
                floor_0[j] += floor_0[j-1]
        print(floor_0[n-1])