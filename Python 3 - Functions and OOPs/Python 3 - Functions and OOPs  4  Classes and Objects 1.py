class Movie:
    def __init__(self, name, n, cost):
        self.name = name
        self.n = n
        self.cost = cost

    def __str__(self):
        return "Movie : %s\nNumber of Tickets : %s\nTotal Cost : %s" % (self.name, self.n, self.cost)

if __name__ == '__main__':
    name = input()
    n = int(input().strip())
    cost = int(input().strip())

    p1 = Movie(name, n, cost)
    print(p1)
