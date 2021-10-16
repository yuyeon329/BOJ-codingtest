import sys


def factorial(a):
    if a < 2:
        return 1
    else:
        return a*factorial(a-1)


if __name__ == '__main__':
    T = int(sys.stdin.readline())
    for _ in range(T):
        N, M = map(int, sys.stdin.readline().split())
        print(factorial(M)//(factorial(M-N)*factorial(N)))