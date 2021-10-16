if __name__ == '__main__':

    T = int(input())
    for _ in range(T):
        n = int(input())
        clothes = {}
        for _ in range(n):
            item, group = map(str, input().split())
            if group not in clothes:
                clothes[group] = 1
            else:
                clothes[group] += 1
        answer = 1
        for i in clothes:
            answer *= (clothes[i]+1)
        print(answer-1)
