if __name__ == '__main__':
    N = int(input())
    cnt = 0
    for _ in range(N):
        s = input()
        tmp = s[0]
        cmp = ""
        for i in range(1, len(s)):
            if s[i] != s[i-1]:
                tmp += (s[i])

        for i in tmp:
            if i not in cmp:
                cmp += i
        if tmp == cmp:
            cnt += 1
    print(cnt)







