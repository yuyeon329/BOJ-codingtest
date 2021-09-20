if __name__ == '__main__':
    N = int(input())
    num = 666
    cnt = 0
    while True:
        if '666' in str(num):
            cnt += 1
        if cnt == N:
            print(num)
            break
        else:
            num += 1




