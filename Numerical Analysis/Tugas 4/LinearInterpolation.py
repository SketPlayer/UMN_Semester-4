def my_lin_interp(x, y, X):
    Y = []
    for xi in X:
        # Find index of the largest element in x that is less than or equal to xi
        i = 0
        while i < len(x) and x[i] <= xi:
            i += 1

        # Perform linear interpolation if xi is within the range of x
        if i > 0 and i < len(x):
            # Linear interpolation formula: y = y1 + (y2 - y1) * ((x - x1) / (x2 - x1))
            x1, x2 = x[i - 1], x[i]
            y1, y2 = y[i - 1], y[i]
            interpolated_y = y1 + (y2 - y1) * ((xi - x1) / (x2 - x1))
            Y.append(interpolated_y)
        # If xi is outside the range of x, take the value at the nearest end
        elif i == 0:
            Y.append(y[0])
        elif i == len(x):
            Y.append(y[-1])

    return Y

# Test case
x = [0,1,2]
y = [1,3,2]
X = [0.0,0.5,1.0,1.5,2.0]

Y = my_lin_interp(x, y, X)
print(Y)

# Another test case
x = [-2, 0, 2, 3, 6]
y = [2, 0, 2, 1, 2]
X = [-1, -0.5, 0.5, 1, 2.5, 4, 5]

Y = my_lin_interp(x, y, X)
print(Y)