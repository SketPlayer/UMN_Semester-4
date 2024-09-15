import numpy as np

# Define basis functions
def basis1(x):
    return np.ones_like(x)

def basis2(x):
    return x

# Define your function list
func = [basis1, basis2]

# Define the my_ls_params function
def my_ls_params(f, x, y):
    # Number of data points
    n = len(x)
    # Number of basis vectors
    m = len(f)

    # Construct the design matrix
    A = np.zeros((n, m))
    for i in range(n):
        for j in range(m):
            A[i, j] = f[j](x[i])

    # Use numpy.linalg.lstsq
    beta = np.linalg.lstsq(A, y, rcond=None)[0]
    return beta

# Test case
x = np.linspace(0, 1, 101)
y = 1 + x + x * np.random.random(len(x))

beta = my_ls_params(func, x, y)
print(beta)
