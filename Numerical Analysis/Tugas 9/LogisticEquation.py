import numpy as np
from scipy.integrate import solve_ivp
import matplotlib.pyplot as plt
from functools import partial

def my_logistics_eq(t, P, r, K):
    dP = r * P * (1 - P / K)
    return dP

dP = my_logistics_eq(0, 10, 1.1, 15)
print("dP = ", dP)

t0 = 0
tf = 20
P0 = 10
r = 1.1
K = 20
t = np.linspace(0, 20, 2001)

f = partial(my_logistics_eq, r=r, K=K)
sol=solve_ivp(f,[t0,tf],[P0],t_eval=t)

plt.figure(figsize = (10,8))
plt.plot(sol.t, sol.y[0])
plt.plot(t, K*P0*np.exp(r*t)/(K + P0*(np.exp(r*t)-1)), 'r:')
plt.xlabel('Time')
plt.ylabel('Population')

plt.legend(['Numerical Solution', ' Exact Solution'])
plt.grid(True)
plt.show()
