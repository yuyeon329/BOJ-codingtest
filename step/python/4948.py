if __name__ == '__main__':
    def prime(M, N):
        N += 1
        sieve = [True] * N
        cnt = 0
        for i in range(2, int(N**0.5)+1):
            if sieve[i]:
                for j in range(i+i, N, i):
                    sieve[j] = False

        for i in range(M, N):
            if 1 < i and sieve[i]:
                cnt += 1
        return cnt

    while True:
        N = int(input())
        if N == 0:
            break
        else:
            print(prime(N+1, N*2))
