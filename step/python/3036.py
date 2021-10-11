import sys

def gcd(a, b):
    if a % b == 0:
        return b
    else:
        return gcd(b, a % b)


if __name__ == '__main__':
    N = int(input())
    data = list(map(int, sys.stdin.readline().split()))

    for i in range(1, len(data)):
        tmp = gcd(data[0], data[i])
        print('{0}/{1}'.format(data[0]//tmp, data[i]//tmp))
