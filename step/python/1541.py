if __name__ == '__main__':
    data = list(input().split('-'))
    new_data = []
    for i in data:
        tmp = list(i.split('+'))
        sum_tmp = 0
        for j in tmp:
            sum_tmp += int(j)
        new_data.append(sum_tmp)

    answer = new_data[0]
    for i in range(1, len(new_data)):
        answer -= new_data[i]

    print(answer)
