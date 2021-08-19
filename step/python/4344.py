if __name__ == '__main__':
    C = int(input())
    for _ in range(C):
        arr = list(map(int, input().split()))
        avg = sum(arr[1:])/arr[0]
        cnt = 0
        for i in arr[1:]:
            if i > avg:
                cnt += 1
        rate = cnt/arr[0]*100
        print(f'{rate:.3f}%')
