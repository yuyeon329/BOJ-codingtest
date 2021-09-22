if __name__ == "__main__":
    N = int(input())
    point_list = []
    for _ in range(N):
        tmp = ()
        tmp = tuple(map(int, input().split()))
        point_list.append(tmp)

    point_list = sorted(point_list, key=lambda x: (x[0], x[1]))

    for i in point_list:
        print(i[0], i[1])