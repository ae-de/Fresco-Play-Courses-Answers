def isprime(n):
    for x in range(2, n):
        if n % x == 0:
            return False
    return True


def primegenerator(num, val):
    temp_list = []
    for n in range(2, num):
        if isprime(n):
            temp_list.append(n)
    # Checking values
    if val == 0:
        for z in range(1, len(temp_list), 2):
            yield temp_list[z]
    if val == 1:
        for z in range(0, len(temp_list), 2):
            yield temp_list[z]


if __name__ == '__main__':

    num = int(input().strip())

    val = int(input().strip())

    for i in primegenerator(num, val):
        print(i, end=" ")
