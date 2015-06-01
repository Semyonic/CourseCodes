__author__ = 'Semih Onay'

import random,numpy


def _generate_random_list(length, start, end):
    """

    :param length: numberOfElements to generate
    :param start: minimum randomValue
    :param end: maximum randomValue
    :return: listOfNumbers
    """

    data = range(start, end)
    random.shuffle(data)
    return data


def scale(listofnumbers, new_min, new_max):
    """

    :param listofnumbers: a list of integers
    :param new_min: new lower limit of integers
    :param new_max: new upper limit of integers
    :return: a number
    """
    newrange = float(new_max - new_min)
    oldmin = min(listofnumbers)
    oldmax = max(listofnumbers)
    oldrange = float(oldmax - oldmin)
    factor = newrange / oldrange

    new_list = []
    for OldValue in listofnumbers:
        new_value = ((OldValue - oldmin) * factor) + new_min
        new_list.append(new_value)
    return new_list

mylist = _generate_random_list(10, 10, 100)
scaledData = scale(mylist, 0, 1.0)

print scale(mylist,10,100)

myData = [416,243,123,186,273,164]



#NOT FINISHED YET #

# def standardize(listofnumbers):
#     """
#
#     :param listofnumbers: a list of integers
#     """
#     mu = Average()
#     sig = StandardDeviation()
#     for i=0;i < rows;i++
#     for (j=0;j < cols;j++)
#     listofnumbers[i, j] = (listofnumbers[i, j]-mu) / sig;
#
#