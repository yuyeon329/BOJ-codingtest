import sys
if __name__ == '__main__':
    N = int(input())
    divisor = list(map(int, sys.stdin.readline().split()))
    print(min(divisor)*max(divisor))
