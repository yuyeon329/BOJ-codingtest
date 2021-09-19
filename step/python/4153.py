if __name__ == '__main__':
    while True:
        triangle = list(map(int, input().split()))
        triangle = sorted(triangle)
        if sum(triangle) == 0:
            break

        print("right" if triangle[2]**2 == triangle[0]**2 + triangle[1]**2 else "wrong")
