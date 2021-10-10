import sys
if __name__ == '__main__':
    N = int(input())
    roads = list(map(int, sys.stdin.readline().split()))
    oils = list(map(int, sys.stdin.readline().split()))

    answer = oils[0]*roads[0]
    price = oils[0]

    for i in range(1, N-1):
        if oils[i] < price:
            price = oils[i]
        answer += price*roads[i]

    print(answer)

