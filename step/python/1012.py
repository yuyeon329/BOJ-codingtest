def bfs(i, j):
    q = [[i, j]]
    while q:
        node_x = q[0][0]
        node_y = q[0][1]
        del q[0]
        for i in range(4):
            need_visit_x = node_x + x[i]
            need_visit_y = node_y + y[i]
            if 0 <= need_visit_x < N and 0 <= need_visit_y < M and ground[need_visit_x][need_visit_y] == 1:
                ground[need_visit_x][need_visit_y] = 0
                q.append([need_visit_x, need_visit_y])
#bfs : 방문 가능한 곳을 queue에 넣음
#그리고 나서 첫 번째 요소를 꺼내서 (상하좌우던 인접행렬이던 for문으로 탐색해서)방문 가능한 연결된 곳이 있으면 똑같이 방문 처리해주고,
#queue에 넣어주고 반복!

T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())

    ground = [[0 for _ in range(M)] for _ in range(N)]
    answer = 0

    x = [0, 0, -1, 1]
    y = [-1, 1, 0, 0]

    for _ in range(K):
        j, i = map(int, input().split())
        ground[i][j] = 1

    for i in range(N):
        for j in range(M):
            if ground[i][j] == 1:
                answer += 1
                bfs(i, j)

    print(answer)


