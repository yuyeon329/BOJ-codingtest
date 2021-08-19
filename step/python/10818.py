if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    min, max = 1000000, -1000000

    for i in arr:
        if i < min:
            min = i
        if i > max:
            max = i

    print(min, max)
