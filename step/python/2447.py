if __name__ == '__main__':

    def print_stars(star_list):
        arr = []
        for i in range(3*len(star_list)):
            if i//len(star_list) == 1:
                arr.append(star_list[i % len(star_list)] + (" "*len(star_list)) + star_list[i % len(star_list)])
            else:
                arr.append(star_list[i % len(star_list)]*3)

        return arr


    star_list = ["***", "* *", "***"]
    N = int(input())
    cnt = 0
    while N != 3:
        N = int(N/3)
        cnt += 1

    for i in range(cnt):
        star_list = print_stars(star_list)

    for j in star_list:
        print(j)

