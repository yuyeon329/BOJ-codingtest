if __name__ == '__main__':
    A, B, V = map(int, input().split())
    remain = (V-B) % (A-B) and 1 or 0
    print((V-B) // (A-B) + remain)
