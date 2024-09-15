def my_num_int(f, a, b, n, option):
    if option not in ['rect', 'trap', 'simp']:
        raise ValueError("Invalid option")

    h = (b - a) / (n - 1)

    def rectangle_integral():
        integral = 0
        for i in range(1, n):
            integral += f(a + i * h)
        return integral * h

    def trapezoid_integral():
        integral = (f(a) + f(b)) / 2
        for i in range(1, n - 1):
            integral += f(a + i * h)
        return integral * h

    def simpson_integral():
        integral = f(a) + f(b)
        for i in range(1, n - 1):
            if i % 2 == 0:
                integral += 2 * f(a + i * h)
            else:
                integral += 4 * f(a + i * h)
        return integral * h / 3

    if option == 'rect':
        return rectangle_integral()
    elif option == 'trap':
        return trapezoid_integral()
    elif option == 'simp':
        return simpson_integral()

# Test case
f = lambda x: x**2

print(my_num_int(f, 0, 1, 3, 'rect'))

print(my_num_int(f, 0, 1, 3, 'trap'))

print(my_num_int(f, 0, 1, 3, 'simp'))

