if __name__ == '__main__':
    M, N = map(int, input().split())

    def prime(M, N):
        N += 1
        sieve = [True] * N
        for i in range(2, int(N**0.5)+1):
            if sieve[i]:
                for j in range(i+i, N, i):
                    sieve[j] = False

        for i in range(M, N):
            if 1 < i and sieve[i]:
                print(i)
    prime(M, N)
