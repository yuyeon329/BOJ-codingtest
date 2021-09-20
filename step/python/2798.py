import itertools

if __name__ == '__main__':
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))

    arr = itertools.combinations(arr, 3)
    answer = 0
    for i in arr:
        if answer < sum(i) <= M :
            answer = sum(i)

    print(answer)


