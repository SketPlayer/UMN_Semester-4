import numpy as np

def my_nth_root(x, n, tol):
    y = x / 2 # Initial Guess
    error = abs(y ** n - x)

    # Newton-Raphson iteration
    while error > tol:
        y = y - (y ** n - x) / (n * y ** (n - 1))
        error = abs(y ** n - x)

    return y

# Test Case
estimate = my_nth_root(2, 2, 1e-6)
print("estimate =", estimate)
print("sqrt(2) =", np.sqrt(2))

# Another Test Case
estimate = my_nth_root(3, 2, 1e-6)
print("estimate =", estimate)
print("sqrt(3) =", np.sqrt(3))