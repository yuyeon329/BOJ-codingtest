if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    print(sum(arr)*100/(max(arr)*N))
