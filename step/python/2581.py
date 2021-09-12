if __name__ == '__main__':
    M = int(input())
    N = int(input())
    decimal = []

    def prime(n):
        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                return False
        return True

    for i in range(M, N+1):
        if i > 1 and prime(i):
            decimal.append(i)
    if len(decimal):
        print(sum(decimal))
        print(min(decimal))
    else:
        print(-1)


