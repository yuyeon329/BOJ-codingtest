if __name__ == '__main__':
    def is_selfnumber(n):
        N = [int(i) for i in str(n)]
        return n+sum(N)

    check = [True]*10001

    for i in range(10000):
        tmp = is_selfnumber(i+1)
        if tmp < 10001:
            check[tmp] = False

    for i in range(1, 10001):
        if check[i]:
            print(i)




