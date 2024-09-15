import numpy as np
import matplotlib.pyplot as plt

# Define the parameters
n = 4
h = (1-0) / n

# Get A
A = np.zeros((n+1, n+1))
A[0, 0] = 1
A[n, n] = 1
for i in range(1,n):
    A[i, i-1] = 1
    A[i, i] = -2.25
    A[i, i+1] = 1
print(A)

# Get b
b = np.zeros(n+1)
b[0] = 1.1752
b[-1] = 10.0179
print(b)

# Solve the linear equations
y = np.linalg.solve(A, b)
x = np.linspace(0, 1, n+1)

result = np.column_stack((x, y))

# Print the results
print("-----------------------------------")
print("Results: ")
print("-----------------------------------")
print(result)

# Plot the solution
plt.plot(x, y)
plt.xlabel('x')
plt.ylabel('y')
plt.title('Solution of y\'\' = 4y using Finite Difference Method')
plt.grid(True)
plt.show()