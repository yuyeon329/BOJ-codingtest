import sys
if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, sys.stdin.readline().strip().split()))
    arr_set = list(set(arr))
    arr_set.sort()
    dic = {arr_set[i]: i for i in range(len(arr_set))}

    for i in arr:
        print(dic[i], end=" ")
