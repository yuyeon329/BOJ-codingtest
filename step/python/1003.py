if __name__ == '__main__':
    T = int(input())
    for _ in range(T):
        N = int(input())
        zero_arr = [1] + [0] + [0] * (N-1)
        one_arr = [0] + [1] + [0] * (N-1)

        for i in range(2, N+1):
            zero_arr[i] = zero_arr[i-1] + zero_arr[i-2]
            one_arr[i] = one_arr[i-1] + one_arr[i-2]

        print(zero_arr[N], one_arr[N])
