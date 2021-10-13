def factorial(a):
    if a <= 1:
        return 1

    return a * factorial(a-1)

if __name__ == '__main__':
    N, K = map(int, input().split())

    print(factorial(N)//(factorial(N-K)*factorial(K)))
