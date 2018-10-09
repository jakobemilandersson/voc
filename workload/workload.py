SIZE = 10000000

l_ = []
l = []
for i in range(SIZE):
    l.append(i)
    l_.append(-i)


#list.reverse + list.extend workload
def rev_ext(l1, l2):
    l1.reverse()
    l2.reverse()
    
    l1.extend(l2)
    
#list.index workload
def ind(l1):
    l1.index(1)
    l1.index(SIZE/2)
    l1.index(SIZE-1)

rev_ext(l, l_)
ind(l)
