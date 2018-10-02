import time

def stop_timer(start_time):
    print("--- %s seconds ---" % (time.time() - start_time))

def workload_append():
    start_time = time.time()

    list = [1]

    for x in range(0, 1000*1000*10):
        list.append(x)

    stop_timer(start_time)

def workload_insert():
    start_time = time.time()

    list = [1]
    for x in range(0, 1000*1000*5):
        list.insert(x, x)

    stop_timer(start_time)

def workload_sort():
    start_time = time.time()

    list = [1]
    for x in range(0, 1000*1000*10)
        list.insert()

workload_append()
workload_sort()
