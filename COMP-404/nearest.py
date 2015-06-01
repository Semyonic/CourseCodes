__author__ = 'Semih'
import math
data1 = [416, 388, 186, 273, 164, 426, 444, 232, 304,
         434, 184, 442, 337, 285, 430, 488, 409, 284, 399, 410,
         331, 438, 173, 343, 496, 345, 252, 222, 391, 134, 405,
         365, 174, 428, 420, 223, 202, 481, 303, 202, 301, 134,
         163, 163, 125, 111, 247, 276, 302, 125]

data2 = [416, 388, 186, -273, 164, -426, -444, -232, 304,
         434, 184, -442, 337, 285, -430, -488, 409, 284, -399, -410,
         331, -438, 173, 343, -496, -345, -252, -222, -391, -134, 405,
         365, -174, 428, -420, -223, 202, -481, -303, -202, 301, 134,
         -163, -163, 125, -111, -247, 276, 302, 125]


def _find_nearest_(_sample_, test):
    """
    :rtype : list
    :type _sample_: list
    :param _sample_: matrix that contains random numbers
    """
    _sample_1_ = []
    _sample_2_ = []
    for i, j in enumerate(_sample_):
        if math.sqrt(i)-math.sqrt(j) <= test:
            _sample_1_.append(i)
        else:
            _sample_2_.append(j)
    return _sample_1_ or _sample_2_

print _find_nearest_(data1, 100)