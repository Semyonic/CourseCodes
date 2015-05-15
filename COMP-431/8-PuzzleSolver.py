__author__ = 'Semih'

initial_state = [[1, 0, 3], [4, 2, 5], [7, 8, 6]]
hard_state = [[0, 8, 7], [6, 5, 4], [3, 2, 1]]
goal_state = [[1, 2, 3], [4, 5, 6], [7, 8, 0]]

_1D = list()


def convert_1d(_2d_matrix):
    for i in range(len(_2d_matrix)):
        for j in range(len(_2d_matrix)):
            _1D.append(_2d_matrix[i][j])

    return _1D


def inversion(matrix):
    inv = 0
    converted_matrix = convert_1d(matrix)
    for i in range(len(converted_matrix)):
        if converted_matrix.index(i) < i and converted_matrix.index(i) != 0 and converted_matrix.index(i):
            inv += 1
    return inv


def find_N(matrix_2D):
    m_1D = convert_1d(matrix_2D)
    inversion = 0
    for index in range(len(m_1D)):
        temp = m_1D[index]
        if temp == 0 or temp == 1:
            continue
        for elem in m_1D[index:]:
            if elem == 0:
                continue
            if (temp > elem):
                inversion += 1
    return inversion


print inversion(initial_state)
print "WTF" ,find_N(initial_state)
