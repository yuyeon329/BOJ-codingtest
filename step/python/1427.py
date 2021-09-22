if __name__ == '__main__':
    N = int(input())
    N_list = list(map(int, str(N)))
    print("".join(map(str, sorted(N_list, reverse=True))))