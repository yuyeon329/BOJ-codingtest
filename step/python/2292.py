if __name__ == '__main__':
    N = int(input())
    room = 1
    start = 1
    step = 6
    while start < N:
        room += 1
        start += step
        step += 6

    print(room)
