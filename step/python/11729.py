if __name__ == '__main__':
    def hanoi(n, start, goal, tmp):
        if n == 1:
            print(start, goal)
            return
        hanoi(n-1, start, tmp, goal)
        print(start, goal)
        hanoi(n-1, tmp, goal, start)

    N = int(input())
    print(2**N-1)
    hanoi(N, 1, 3, 2)
