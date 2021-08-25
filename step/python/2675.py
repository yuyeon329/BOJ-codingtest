if __name__ == '__main__':
    N = int(input())

    for i in range(N):
        n, s = input().split()
        tmp = ""
        for j in s:
            tmp += j*int(n)
        print(tmp)
