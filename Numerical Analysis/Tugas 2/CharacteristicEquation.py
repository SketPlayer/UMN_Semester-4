# Trace
def findTrace(mat, n):
    sum = 0
    for i in range(n):
        sum += mat[i][i]
    return sum

# Function for calculating determinant of matrix
def determinantOfMatrix(mat):
    return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0]

# Given matrix A
A = [[3, 2], [5, 3]]

# Calculate characteristics of A
trace_A = findTrace(A, 2)
determinant_A = determinantOfMatrix(A)

# Output the characteristic equation
print("Characteristic equation of matrix A:")
print(f"lambda^2", end=" ")

if trace_A != 0:
    print(f"- {trace_A}lambda", end=" ")

if determinant_A != 0:
    print(f"+ {determinant_A} = 0")
else:
    print("= 0")
