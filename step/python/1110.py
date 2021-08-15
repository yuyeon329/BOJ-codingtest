if __name__ == '__main__':
    N = int(input())
    tmp = N
    cnt = 0
    while True:
        cnt += 1
        ten = tmp//10
        one = tmp%10
        s = ten+one
        tmp = one*10 + s%10

        if tmp == N:
            break
    print(cnt)
