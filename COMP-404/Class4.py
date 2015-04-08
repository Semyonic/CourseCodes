__author__ = 'Semih'

import random


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


def _get_max(lon):
    """

    :param lon: listOfNumbers
    :return: maximum value of given listOfNumbers
    """
    maxval=0
    for i in enumerate(lon):
        maxval=max(i)
    return maxval


def _get_min(lon):
    """

    :param lon: listOfNumbers
    :return:
    """
    minval=0
    for i in enumerate(lon):
        minval=min(i)
    return minval


def _euclid_distance(lon, maxval, minval):
    maxval=max(lon)
    minval=min(lon)
    _euclid_dist=pow(maxval, minval, 2)
    return _euclid_dist


def _prim_knn(lon,maxVal):
    temp = 999199
    temp2 = 0
    for i in lon:
        if i-maxVal < temp:
            temp2=i
    return temp2