import numpy as np
import matplotlib.pyplot as plt

# step size
h = 0.1
#define grid
x = np.arange(0, 2*np.pi, h)
# compute function
y = np.cos(x)

# compute vector of backward differences
backward_diff = np.diff(y)/h
# compute corresponding grid
x_diff = x[1:]
# compute exact solution
exact_solution = -np.sin(x_diff)

# Compute max error between
# numerical derivative and exact solution
max_error = max(abs(exact_solution - backward_diff))
print('Max error = ', max_error)

# Plot solution
plt.figure(figsize = (12, 8))
plt.plot(x_diff, backward_diff, '--', \
  label = 'Backward difference approximation')
plt.plot(x_diff, exact_solution, \
  label = 'Exact solution')
plt.legend()
plt.show()
