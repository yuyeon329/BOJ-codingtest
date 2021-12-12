#x,y 배열 가로세로 헷갈리지 말기
def bfs(vx, vy):
    q = [[vx, vy]]
    while q:
        node_x = q[0][0]
        node_y = q[0][1]
        del q[0]
        for i in range(4):
            needVisit_x = node_x + x[i]
            needVisit_y = node_y + y[i]
            if 0 <= needVisit_x < N and 0 <= needVisit_y < M and myMaze[needVisit_x][needVisit_y] == "1":
                myMaze[needVisit_x][needVisit_y] = str(int(myMaze[node_x][node_y]) + 1)
                q.append([needVisit_x, needVisit_y])


N, M = map(int, input().split())
myMaze = []
x = [0, 0, -1, 1]
y = [-1, 1, 0, 0]

for _ in range(N):
    myMaze.append(list(input()))

bfs(0, 0)

print(myMaze[N-1][M-1])

