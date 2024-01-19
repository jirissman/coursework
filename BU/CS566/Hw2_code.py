def Maxsort (E):
    last_index = len(E)
    for _ in E:
        max_index = 0
        max_value = E[0]
        for x in range(last_index):
            if E[x]>max_value:
                max_index = x
                max_value = E[x]
        E[max_index] = E[x]
        E[x] = max_value
        last_index -= 1
    return E

import random
random_array = [random.randint(1, 100) for _ in range(10)]
print(Maxsort(random_array))
print(Maxsort([5,8,0,4,3,9,1,2,7,6]))
print(Maxsort([50,564,651,198,16,2301,98,63,4742]))