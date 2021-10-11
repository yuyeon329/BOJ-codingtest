def gcd(a, b):
    if a % b == 0:
        return b
    else:
        return gcd(b, a%b)


def lcm(a, b):
    return a*b//gcd(a, b)


if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        A, B = map(int, input().split())
        print(lcm(A, B))