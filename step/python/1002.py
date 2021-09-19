if __name__ == '__main__':
    T = int(input())
    for _ in range(T):
        x1, y1, r1, x2, y2, r2 = map(int, input().split())
        distance = ((x1-x2)**2 + (y1-y2)**2)**0.5

        if distance == 0:
            if r1 == r2:
                print(-1)
            else:
                print(0)
        elif distance < abs(r1-r2) or (r1+r2) < distance:
            print(0)
        else:
            if distance == r1+r2 or distance == abs(r1-r2):
                print(1)
            else:
                if abs(r1-r2) < distance < (r1+r2):
                    print(2)

