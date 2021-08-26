if __name__ == '__main__':
    alpha = [0]*26
    s = input()
    s = s.upper()

    for i in s:
        alpha[ord(i)-65] += 1

    tmp = sorted(alpha, reverse=True)
    if tmp[0] == tmp[1]:
        print("?")
    else:
        print(chr(alpha.index(max(alpha))+65))



