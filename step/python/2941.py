if __name__ == '__main__':
    croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
    s = input()
    for i in croatia:
        s = s.replace(i, '.')
    print(len(s))


