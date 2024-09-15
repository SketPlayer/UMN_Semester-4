import numpy as np
import pprint
import scipy.linalg

A = np.array([
    [3, -1, 4],
    [17, 2, 1],
    [1, 12, -7]
])
P, L, U = scipy.linalg.lu(A)

print ("A:")
pprint.pprint(A)

print ("L:")
pprint.pprint(L)

print ("U:")
pprint.pprint(U)