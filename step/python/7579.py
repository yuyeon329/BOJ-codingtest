#공부중
N, M = map(int, input().split())
A = [0] + list(map(int, input().split())) #dp 연산 시 n번째 계산하기 편하게 앞에 0 붙여줌 + 첫번째 앱을 꺼야할 때 초기화 용
C = [0] + list(map(int, input().split()))  #최악의 경우 모든 앱을 비활성화해야 할 수도
dp = [[0 for _ in range(sum(C)+1)] for _ in range(N+1)] #dp 계산 용 list 생성
# #dp[i][j] = i번째 앱까지 중 j코스트로 얻을 수 있는 최대의 byte

result = sum(C)
if M == 0:
    print(0)

else:
    for i in range(1, N+1):
        b = A[i]
        c = C[i]

        for j in range(1, sum(C)+1):
            if j < c: #비용이 cost보다 작다면 끄지 못하므로 활성화
                dp[i][j] = dp[i-1][j]
            else: #비용이 cost보다 크다면 비활성화 한 byte와 활성화한 byte 중 큰 값을 dp에 저장
                dp[i][j] = max(b+dp[i-1][j-c], dp[i-1][j])

            if dp[i][j] >= M: #dp값이 M이상이라면, 현재의 비용과 result중 작은 값을 정답에 넣어줌
                result = min(result, j)

    print(result)