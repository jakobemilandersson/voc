import time

#For measuring time of a function
def measure(func):
    start_time = time.time()
    func()
    
    print(func.__name__ + ": %s seconds" % (time.time() - start_time))

#list.reverse + list.extend workload
def rev_ext():
    l = []
    l_ = []
    
    for i in range(10000000):
        l.append(i)
        l_.append(-i)
    
    l.reverse()
    l_.reverse()
    
    l.extend(l_)
    
#list.index workload
def ind():
    l = [i for i in range(20000)]
    
    for element in l:
        garbage = l.index(element)
    
measure(rev_ext)
measure(ind)