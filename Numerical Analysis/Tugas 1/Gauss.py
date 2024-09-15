from fractions import Fraction

# Creating a function to print the augmented matrix with the given set of linear equations
def print_aug(mat):
    no = len(mat)
    for i in range(0, no):
        l = ""
        for k in range(0, n + 1):
            l += str(mat[i][k]) + "\t"
            if k == n - 1:
                l += "| "
        print(l)
    print("")

# Creating a function to perform Gaussian elimination on the given matrix mat
def gauss_elem(mat):
    num = len(mat)

    for i in range(0, num):
        # Searching the maximum value of a particular column
        max_el = abs(mat[i][i])
        # Row having the element of maximum value
        max_row = i
        for k in range(i + 1, num):
            if abs(mat[k][i]) > max_el:
                max_el = abs(mat[k][i])
                max_row = k

        # Swapping the maximum row with the current row
        for k in range(i, n + 1):
            temp = mat[max_row][k]
            mat[max_row][k] = mat[i][k]
            mat[i][k] = temp

        # Chaning the value of the rows below the current row to 0
        for k in range(i + 1, n):
            curr = -mat[k][i] / mat[i][i]
            for j in range(i, n + 1):
                if i == j:
                    mat[k][j] = 0
                else:
                    mat[k][j] += curr * mat[i][j]

    # Solving the equation Ax = b for the created upper triangular matrix mat
    l = [0 for i in range(n)]
    for j in range(n - 1, -1, -1):
        l[j] = mat[j][n] / mat[j][j]
        for k in range(j - 1, -1, -1):
            mat[k][n] -= mat[k][j] * l[j]
    return l


if __name__ == "__main__":
    n = 3  # Number of variables

    # Coefficients and constants for the linear equations
    A_mat = [
        [3, -1, 4, 2],
        [17, 2, 1, 14],
        [1, 12, -7, 54]
    ]

    # Printing the augmented matrix from the fixed input data
    print_aug(A_mat)

    # Calculating the solution of the matrix
    x = gauss_elem(A_mat)

    # Printing the result
    print("Result:")
    for j in range(n):
        print(f"x{j + 1} = {x[j]}")
