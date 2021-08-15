if __name__ == '__main__':
    while True:
        try :
            a, b = map(int, input().split())
        except :
            break
        print(a+b)
