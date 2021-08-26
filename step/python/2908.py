if __name__ == '__main__':
    a, b = map(str, input().split())
    a = ''.join(reversed(a))
    b = ''.join(reversed(b))
    print(max(int(a), int(b)))
