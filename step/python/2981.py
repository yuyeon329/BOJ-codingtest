def gcd(a, b):
    if a % b == 0:
        return b
    else:
        return gcd(b, a % b)


def solution(arr):
    if len(arr) == 1:
        return arr[0]
    while len(arr) > 1:
        arr.append(gcd(arr.pop(), arr.pop()))

    return arr[0]


if __name__ == '__main__':
    data = []
    data_sub = []
    N = int(input())
    for i in range(N):
        data.append(int(input()))
        if i :
            data_sub.append(abs(data[i]-data[i-1]))

    end = solution(data_sub)
    answer = []
    for i in range(2, int(end**0.5)+1):
        if end % i == 0:
            answer.append(i)
            answer.append(end//i)
    answer.append(end)
    answer = list(set(answer))
    answer.sort()
    for i in answer:
        print(i, end=' ')
