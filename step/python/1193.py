if __name__ == '__main__':
    X = int(input())
    num = 0
    step = 0
    numerator = 0
    denominator = 0
    while num < X:
        step += 1
        num += step

    num -= step

    if step % 2 == 0:
        numerator = X - num
        denominator = step - (X-num - 1)
    else:
        numerator = step - (X-num - 1)
        denominator = X - num

    print(f'{numerator}/{denominator}')



