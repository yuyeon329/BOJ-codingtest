if __name__ == "__main__":
    M, N = map(int, input().split())
    chess = []
    min_case = []

    for _ in range(M):
        chess.append(input())

    for i in range(M-7): #입력에서 가능한 8x8세트 탐색
        for j in range(N-7):
            black_first, white_first = 0, 0

            for k in range(i, i+8):#8x8 옮기기
                for l in range(j, j+8):
                    if (k+l) % 2 != 0:
                        if chess[k][l] != 'B':
                            black_first += 1
                        if chess[k][l] != 'W':
                            white_first += 1
                    else:
                        if chess[k][l] != 'W':
                            black_first += 1
                        if chess[k][l] != 'B':
                            white_first += 1


            min_case.append(black_first)
            min_case.append(white_first)
    print(min(min_case))



