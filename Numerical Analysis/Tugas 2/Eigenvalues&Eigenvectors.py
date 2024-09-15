import numpy as np 

# Create numpy 2d-array 
m = np.array([[3, 2], 
			[5, 3]]) 

print("Matrix A:\n", 
	m) 

# Finding eigenvalues and eigenvectors 
w,v = np.linalg.eig(m) 

# Printing eigen values 
print("Eigenvalues:\n", w) 

# Printing eigen vectors 
print("Eigenvectors:\n", v)
