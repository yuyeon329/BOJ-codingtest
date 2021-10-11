def gcd(a, b):
    if a % b == 0:
        return b
    else:
        return gcd(b, a % b)


if __name__ == '__main__':
    A, B = map(int, input().split())
    print(gcd(A, B))
    print((A*B)//gcd(A, B))
