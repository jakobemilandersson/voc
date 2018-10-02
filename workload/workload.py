import time
from random import randint

def stop_timer(start_time):
    print("--- %s seconds ---" % (time.time() - start_time))

def workload_append():
    start_time = time.time()

    list = []
    for x in range(0, 1000*1000*10):
        list.append(x)

    stop_timer(start_time)

def workload_insert():
    start_time = time.time()

    list = [1]
    for x in range(0, 1000*1000*5):
        list.insert(x, x)

    stop_timer(start_time)

'''
            Mixat, skapa lista, fyll med element, sortera, 
            hitta ett visst element, ta bort det, 
            lägg till ett nytt element. - Jacob


    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    !!!   Im not to sure of how we would like it to be like,     !!!
    !!!   if I should sort, find and replace more than just one  !!!
    !!!   element or keep it this way?                           !!!
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
'''
def workload_mix():
    #Create and populate a List object with 999'999 random integers
    #and then lastly append '4222193' for searching purposes. 
    rand_list = []
    for x in range(0, (1000*1000)-1):
        rand_list.append(randint(0, 1000*1000))

    rand_list.append(4222193)

    start_time = time.time()

    #Create and populate a List object with all elements from
    #'rand_list', then sort the list, find the position of element
    #with value '4222193', pop the index and add '-1' at
    #that position instead.
    #
    #Not to sure if this is an appropiate way of doing this,
    #but keeping it until you guys have seen it and said
    #what you think! :)
    list = []
    for x in range(0,1000*1000):
        list.append(rand_list[x])

    list.sort()
    ind = list.index(4222193)
    list.pop(ind)
    list.insert(ind, -1)

    stop_timer(start_time)

workload_append()
workload_insert()
workload_mix()
