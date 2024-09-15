import numpy as np
import matplotlib.pyplot as plt

# Define the function sin(x)/x
def sin_x_over_x(x):
    return np.sin(x) / x

# Define the range of x values
x_values = np.linspace(-3, 3, 1000)
x_values = x_values[x_values != 0]  # Remove x=0 to avoid division by zero

# Calculate the approximation sin(x)/x ≈ 1
approximation = np.ones_like(x_values)

# Plot the results
plt.figure(figsize=(8, 6))
plt.plot(x_values, sin_x_over_x(x_values), label='sin(x)/x')
plt.plot(x_values, approximation, linestyle='--', color='red', label='Approximation: 1')
plt.xlabel('x')
plt.xlim(-3.0, 3.0)
plt.ylabel('sin(x)/x')
plt.ylim(-3.0, 3.0)
plt.title('Approximation of sin(x)/x ≈ 1')
plt.legend()
plt.grid(True)
plt.show()
