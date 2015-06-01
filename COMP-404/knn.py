__author__ = 'Semih'
import random

def _generate_random_list(start, end):
    """
    :rtype : list
    :type start: int
    :type end: int
    :param start: minimum randomValue
    :param end: maximum randomValue
    :return: listOfNumbers
    """

    matrix = range(start, end)
    random.shuffle(matrix)
    return matrix

_set1_ = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
_set2_ = _generate_random_list(0, 9)


def _k_fold_(_sample_, k):
    """
    :rtype : list
    :type k: int
    :param k: number of folding
    :type _sample_: list
    :param _sample_: matrix that contains random numbers
    """
    for l in range(k):
        _sample_1_ = []
        _sample_2_ = []
    for i, j in enumerate(_sample_):
        if i % l != k:
            _sample_1_.append(i)
        else:
            _sample_2_.append(j)
    yield _sample_1_, _sample_2_


print _k_fold_(_set2_, 10)