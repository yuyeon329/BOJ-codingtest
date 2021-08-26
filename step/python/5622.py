if __name__ == '__main__':
    dial = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', "WXYZ"]
    str = input()
    time = 0

    for i in range(len(str)):
        for j in dial:
            if str[i] in j:
                time += dial.index(j)+3
    print(time)


