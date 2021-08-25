if __name__ == '__main__':
    S = input()
    alpha = [-1]*26

    for i in range(len(S)):
        tmp = ord(S[i])-97
        if alpha[tmp] == -1:
            alpha[tmp] = i

    for i in alpha:
        print(i, end=" ")
