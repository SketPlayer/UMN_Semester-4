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

# Creating a function to perform Gauss-Jordan elimination on the given matrix mat
def gauss_jordan(mat):
    num = len(mat)

    for i in range(0, num):
        # Divide the row by the diagonal element to make it 1
        div = mat[i][i]
        for j in range(i, num + 1):
            mat[i][j] /= div

        # Make all other elements in the column zero
        for j in range(0, num):
            if i != j:
                factor = mat[j][i]
                for k in range(i, num + 1):
                    mat[j][k] -= factor * mat[i][k]

    # Extract solutions
    solutions = [row[-1] for row in mat]
    return solutions

if __name__ == "__main__":
    n = 3  # Number of variables

    # Coefficients and constants for the linear equations
    A_mat = [
        [3, -1, 4, 2],
        [17, 2, 1, 14],
        [1, 12, -7, 54]
    ]

    # Printing the augmented matrix from the fixed input data
    print("Original Augmented Matrix:")
    print_aug(A_mat)

    # Solving the equations using Gauss-Jordan elimination
    solutions = gauss_jordan(A_mat)

    # Printing the solutions
    print("\nSolutions:")
    for i, sol in enumerate(solutions):
        print(f"x{i + 1} = {sol}")
