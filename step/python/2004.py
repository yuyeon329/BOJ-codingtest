import sys


def count_five(n):
    count = 0
    while n != 0:
        n //= 5
        count += n

    return count


def count_two(n):
    count = 0
    while n != 0:
        n //= 2
        count += n

    return count


if __name__ == '__main__':
    n, m = map(int, sys.stdin.readline().split())
    print(min(count_two(n)-count_two(m)-count_two(n-m), count_five(n)-count_five(m)-count_five(n-m)))
