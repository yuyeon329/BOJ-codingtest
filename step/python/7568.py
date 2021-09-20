if __name__ == '__main__':
    N = int(input())
    rank = [0]*N
    info_list = []
    for i in range(N):
        info = list(map(int, input().split()))
        info_list.append(info)

    for j in range(N):
        cnt = 1
        for k in range(N):
            if j == k:
                continue
            else:
                if info_list[j][0] < info_list[k][0] and info_list[j][1] < info_list[k][1]:
                    cnt += 1
        rank[j] = cnt

    print(" ".join(map(str, rank)))
