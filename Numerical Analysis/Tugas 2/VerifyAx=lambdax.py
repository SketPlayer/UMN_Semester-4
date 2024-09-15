import numpy as np

# Define the matrix A
A = np.array([[3, 2], [5, 3]])

# Define the eigenvalue lambda
lambda_value = 3 + np.sqrt(10)

# Define the eigenvector x
x = np.array([2, np.sqrt(10)])

# Verify if Ax = lambda*x
Ax = np.dot(A, x)
lambda_x = lambda_value * x

# Ensure both arrays have the same dtype for comparison
lambda_x = lambda_x.astype(Ax.dtype)

# Print the Ax and lambda_x
print("Ax:", Ax)
print("lambda_x:", lambda_x)

# Define a tolerance
tolerance = 1e-8

# Check if the absolute difference between corresponding elements is within the tolerance
if np.all(np.abs(Ax - lambda_x) < tolerance):
    print("Ax = lambda*x is verified.")
else:
    print("Ax = lambda*x is not verified.")
