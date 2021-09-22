if __name__ == '__main__':
    N, M = map(int, input().split())
    arr = []

    def dfs():
        if len(arr) == M:
            print(" ".join(map(str, arr)))
            return
        for i in range(1, N+1):
            if len(arr) >= 1:
                if i not in arr and i > arr[-1]:
                    arr.append(i)
                    dfs()
                    arr.pop()
            else:
                if i not in arr:
                    arr.append(i)
                    dfs()
                    arr.pop()

    dfs()