if __name__ == '__main__':
    def is_arithmetic_sequence(n):
        N = [int(i) for i in str(n)]
        if N[0]-N[1] == N[1]-N[2]:
            return True
        else:
            return False

    N = int(input())

    cnt = 0
    if N<100:
        print(N)
    else:
        for i in range(100, N+1):
            if is_arithmetic_sequence(i):
                cnt += 1
        print(99+cnt)
