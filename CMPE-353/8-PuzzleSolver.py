__author__ = 'Semih'

initial_state = [[1, 0, 3], [4, 2, 5], [7, 8, 6]]
hard_state = [[0, 8, 7], [6, 5, 4], [3, 2, 1]]
goal_state = [[1, 2, 3], [4, 5, 6], [7, 8, 0]]
fail_state = [[0, 4, 5, 9], [1, 3, 2], [7, 8, 6]]

_1D = list()


def convert_1d(_2d_matrix):
    """

    :param _2d_matrix: takes 2-dimensional matrix
    :return: 1-dimensional matrix
    """
    for i in range(len(_2d_matrix)):
        for j in range(len(_2d_matrix)):
            _1D.append(_2d_matrix[i][j])

    return _1D


def inversion(matrix):
    """

    :param matrix: 1-dimensional matrix
    :return: number of inversions
    """
    inv = 0
    converted_matrix = convert_1d(matrix)
    for i in range(len(converted_matrix)):
        if converted_matrix.index(i) < i and converted_matrix.index(i) != 0 and converted_matrix.index(i):
            inv += 1
    return inv


def find_inversion2(matrix_2dim):
    """

    :param matrix_2dim: 2-dimensional matrix
    :return: number of inversions
    """
    inversion = 0
    m_1dim = convert_1d(matrix_2dim)
    for index in range(len(m_1dim)):
        temp = m_1dim[index]
        if temp == 0 or temp == 1:
            continue
        for elem in m_1dim[index:]:
            if elem == 0:
                continue
            if temp > elem:
                inversion += 1
    return inversion


def is_solvable2(matrix):
    """

    :param matrix: a matrix with 2-dimension
    :return: given matrix is solvable or not as boolean
    """
    x = 0
    for i in range(len(matrix)):
        temp = matrix[i]
        if matrix.__len__() < 9:
            continue
        for j in matrix[i:]:
            if j == 0:
                continue
            if temp > j:
                x += 1
    return (x & 1) == 0


def is_valid(matrix):
    sum_of_nums = 0
    sum_of_sqrs = 0
    for i in range(len(matrix)):
        for j in range(len(matrix)):
            sum_of_sqrs += matrix[i][j]
            sum_of_nums += pow(matrix[i][j],2)
        if sum_of_nums == 36 and sum_of_sqrs == 204:
            return True
        else:
            return False


def is_solvable(matrix):
    goal = find_inversion2(goal_state)
    initial = find_inversion2(matrix)
    if (goal % 2) == 0 and (initial % 2) == 0:
        return True
    elif (goal % 2) == 0 and (initial % 2) == 1:
        return True
    else:
        return False


def possible_moves(matrix,value):
    """

    :param matrix: 2-dimensional matrix
    :param value: value to find in matrix
    :return: tuple of given value index
    """
    temp = (0, 0)
    for i in range(len(matrix)):
        for j in range(len(matrix)):
            if value == (matrix[i][j]):
                temp = (i, j).
    return temp

print 0 % 3
print 1 % 3
print 2 % 3
print 3 % 3
print 4 % 3
print 5 % 3
print 6 % 3
print 7 % 3
print 8 % 3

print "End of Modulo"
print inversion(initial_state)
print is_solvable(fail_state)
print possible_moves(goal_state, 6)
