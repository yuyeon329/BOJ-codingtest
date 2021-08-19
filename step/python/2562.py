if __name__ == '__main__':
    arr = []
    max, idx = 0, 0
    for _ in range(9):
        arr.append(int(input()))

    for i in range(len(arr)):
        if arr[i]>max:
            max = arr[i]
            idx = i

    print(max)
    print(idx+1)