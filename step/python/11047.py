import sys
if __name__ == '__main__':
    N, K = map(int, input().split())
    coin = []
    for _ in range(N):
        coin.append(int(sys.stdin.readline()))

    coin = list(reversed(coin))
    coin_cnt = 0
    for i in coin:
        if i > K:
            continue
        else:
            coin_cnt += K//i
            K %= i
    print(coin_cnt)