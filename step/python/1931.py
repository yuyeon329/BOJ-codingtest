import sys
if __name__ == '__main__':
    N = int(sys.stdin.readline())
    timetable = [[0 for _ in range(2)]for _ in range(N)]

    for i in range(N):
        begin, end = map(int, sys.stdin.readline().split())
        timetable[i][0] = begin
        timetable[i][1] = end

    timetable = sorted(timetable, key=lambda x: (x[0]))

    timetable = sorted(timetable, key=lambda x: (x[1]))

    tmp = 0
    cnt = 0
    for i, j in timetable:
        if tmp <= i:
            cnt += 1
            tmp = j

    print(cnt)

