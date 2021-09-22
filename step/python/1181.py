import sys
if __name__ == '__main__':
    N = int(input())
    words = []
    for _ in range(N):
        words.append(sys.stdin.readline().strip())
    words = list(set(words))
    words.sort()
    words.sort(key=len)

    for i in words:
        print(i)
