SIZE = 1000000

l_ = []
l = []
for i in range(SIZE):
    l.append(i)
    l_.append(-i)


# list.reverse + list.extend workload
def ext(l1, l2):
    for i in range(10):
        l1.extend(l2)

def rev(l1,l2):
    for i in range(500):
        l1.reverse()
        l2.reverse()

# list.index workload
def ind(l1):
    for i in range(0, 100):
        l1.index(SIZE-i-1)


rev(l, l_)
ext(l, l_)
ind(l)

