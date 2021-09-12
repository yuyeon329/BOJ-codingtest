if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    answer = 0

    def prime(n):
        for i in range(2, int(n**0.5)+1):
            if n % i == 0:
                return False
        return True

    for k in arr:
        if k > 1 and prime(k):
            answer += 1

    print(answer)
