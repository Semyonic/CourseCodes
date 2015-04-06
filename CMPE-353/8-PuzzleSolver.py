__author__ = 'Semih'


initial_state = [[1, 0, 3], [4, 2, 5], [7, 8, 6]]
goal_state = [[1, 2, 3], [4, 5, 6], [7, 8, 0]]

_1D = list()

def convert_1d(_2d_matrix):
    for i in range(len(_2d_matrix)):
        for j in range(len(_2d_matrix)):
            _1D.append(_2d_matrix[i][j])

    return _1D

def inversion(matrix):
    for i in range(matrix):
        
