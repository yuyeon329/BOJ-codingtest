def dfs(cnt, result, plus, minus, mul, div):
    global min_result
    global max_result

    if cnt == N:
        max_result = max(max_result, result)
        min_result = min(min_result, result)
        return

    if plus:
        dfs(cnt+1, result+arr[cnt], plus-1, minus, mul, div)
    if minus:
        dfs(cnt+1, result-arr[cnt], plus, minus-1, mul, div)
    if mul:
        dfs(cnt+1, result*arr[cnt], plus, minus, mul-1, div)
    if div:
        dfs(cnt+1, -((-result)//arr[cnt]) if result < 0 else int(result//arr[cnt]), plus, minus, mul, div-1)


if __name__ == '__main__':
    min_result = 1000000001
    max_result = -1000000001

    N = int(input())
    arr = list(map(int, input().split()))
    operator_list = list(map(int, input().split()))

    dfs(1, arr[0], operator_list[0], operator_list[1], operator_list[2], operator_list[3])
    print(max_result)
    print(min_result)




