if __name__ == '__main__':
    a = int(input())
    b = int(input())
    c = int(input())
    cnt_arr = [0,0,0,0,0,0,0,0,0,0]
    arr_mul = str(a*b*c)

    for i in arr_mul:
        cnt_arr[int(i)] += 1

    for i in cnt_arr:
        print(i)


