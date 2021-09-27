import itertools

if __name__ == '__main__':
    answer = 1000000
    N = int(input())
    arr = [0 for _ in range(N)]
    nums = [i for i in range(N)]
    my_combi = list(itertools.combinations(nums, N//2))

    for i in range(N):
        arr[i] = list(map(int, input().split()))

    for i in range(len(my_combi)//2):
        star_total = 0
        link_total = 0
        star = list(my_combi[i])
        link = list(my_combi[len(my_combi)-i-1])

        star_combi = list(itertools.combinations(star, 2))
        link_combi = list(itertools.combinations(link, 2))

        for x, y in star_combi:
            star_total += arr[x][y]
            star_total += arr[y][x]

        for x, y in link_combi:
            link_total += arr[x][y]
            link_total += arr[y][x]

        answer = min(answer, abs(star_total-link_total))

    print(answer)














