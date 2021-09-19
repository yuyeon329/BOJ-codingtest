if __name__ == '__main__':
    sieve = [False, False] + [True]*(10000-1)
    primes = []
    for i in range(2, 10000):
        if sieve[i]:
            primes.append(i)
            for j in range(2*i, 10001, i):
                sieve[j] = False

    T = int(input())
    for _ in range(T):
        n = int(input())
        for j in range(n//2, 1, -1):
            tmp = n-j
            if tmp in primes and j in primes:
                print(j, tmp)
                break

