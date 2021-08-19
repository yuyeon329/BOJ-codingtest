if __name__ == '__main__':
    arr = [0]*42
    for _ in range(10):
        arr[(int(input()) % 42)]+=1
    print(42-arr.count(0))

