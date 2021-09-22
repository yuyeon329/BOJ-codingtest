import sys
from collections import Counter


def avg(arr, N):
    return round(sum(arr)/N)


def median(arr, N):
    return arr[N//2]


def mode(arr, N):
    mode_list = Counter(arr)
    modes = mode_list.most_common()

    if N > 1:
        if modes[0][1] == modes[1][1]:
            mod = modes[1][0]
        else:
            mod = modes[0][0]
    else:
        mod = modes[0][0]

    return mod


def arr_range(arr):
    return max(arr)-min(arr)


if __name__ == "__main__":
    arr = []
    N = int(input())
    for _ in range(N):
        arr.append(int(sys.stdin.readline()))

    print(avg(arr, N))
    print(median(sorted(arr), N))
    print(mode(sorted(arr), N))
    print(arr_range(arr))
