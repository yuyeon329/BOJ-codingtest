if __name__ == '__main__':
    N = int(input())
    cnt = 0
    for i in range(N):
        tmp = [int(j) for j in str(i)]
        if i+sum(tmp) == N:
            print(i)
            cnt += 1
            break
    if cnt == 0:
        print(0)
