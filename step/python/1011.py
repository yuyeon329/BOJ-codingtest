if __name__ == '__main__':
    T = int(input())
    for _ in range(T):
        x, y = map(int, input().split())
        d = y - x
        move = 0  # 최대이동거리
        cnt = 0  # 이동 횟수
        set_of_cnt = 1  # 이동 빈도수

        while move < d:
            cnt += 1
            move += set_of_cnt
            if cnt % 2 == 0:
                set_of_cnt += 1
        print(cnt)







