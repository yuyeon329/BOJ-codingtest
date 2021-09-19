if __name__ == '__main__':
    x = []
    y = []
    new_x = 0
    new_y = 0
    for i in range(3):
        x_p, y_p = map(int, input().split())
        x.append(x_p)
        y.append(y_p)

    x = sorted(x)
    y = sorted(y)

    if x[0] == x[1]:
        new_x = x[2]
    else:
        new_x = x[0]

    if y[0] == y[1]:
        new_y = y[2]
    else:
        new_y = y[0]

    print(new_x, new_y)
