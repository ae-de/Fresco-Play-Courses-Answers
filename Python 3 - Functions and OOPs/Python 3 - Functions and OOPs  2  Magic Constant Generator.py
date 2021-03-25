def generator_Magic(n1):
    for test in range(3, n1 + 1):
        yield (test * (pow(test, 2) + 1)) / 2


if __name__ == '__main__':

    n = int(input().strip())

    for i in generator_Magic(n):
        print(int(i))

    gen1 = generator_Magic(n)
    print(type(gen1))
