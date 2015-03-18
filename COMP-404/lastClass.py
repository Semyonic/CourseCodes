arr = [15, 2, 3, 4, 5, 6, 7, 8, 9, 500]
arr_2 = [15, 2, 3, 4, 5, 6, 7, 8, 9, 500]
arr_first = [1, 2, 3, 4, 5]
arr_second = [1, 2, 3, 4, 5]
myList = {10, 20, 30, 40, 50}

def __find_min__(arr1):
    val = 100
    for i in range(len(arr1)):
        if arr1[i] < val:
            val = arr1[i]
    return val

print'Minimum Value : ', __find_min__(arr)

def __find_max(arr1):
    val = 0
    for i in range(len(arr1)):
        if arr1[i] > val:
            val = arr1[i]
    return val

print'Maximum Value : ', __find_max(arr)

def __mult_list__(arr2):
    for i in range(len(arr2)):
        val = i[arr2] * i[arr2]
    return val

#print'Multipicated List : ', __mult_list__(arr)

def __sum_list__(arr1, arr2):
    temp = []
    for i in arr1:
        for j in arr2:
            if i == j:
                temp.append(i + j)
    return temp

print'Summation : ', __sum_list__(arr, arr_2)

def __check_list__(list1, number):
    for index, i in enumerate(list1):
        if i < number:
            temp = i - number
    return temp

print'Check List : ', __check_list__(myList,20)
