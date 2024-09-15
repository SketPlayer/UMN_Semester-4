import numpy as np
import matplotlib.pyplot as plt

# Time array for original signal
t_original = np.arange(0, 2, 1/100)  # 2 seconds, sampling rate 100 Hz

# Signal 1: Sine wave with 5 Hz frequency, amplitude 3, and phase shift 3
signal_1 = 3 * np.sin(2 * np.pi * 5 * t_original + 3)

# Signal 2: Sine wave with 2 Hz frequency, amplitude 2, and phase shift -2
signal_2 = 2 * np.sin(2 * np.pi * 2 * t_original - 2)

# Result signal
result_signal = signal_1 + signal_2

# Sampling rates to compare
sampling_rates = [5, 10, 20, 50, 100]

# Plotting
plt.figure(figsize=(10, 8))

# Plot sampled signals
for i, sr in enumerate(sampling_rates):
    t_sampled = np.arange(0, 2, 1/sr)  # Time array for sampled signal
    result_signal_sampled = np.interp(t_sampled, t_original, result_signal)  # Sampled signal
    
    plt.subplot(5, 1, i+1)
    plt.plot(t_sampled, result_signal_sampled, label=f'Sampled Signal ({sr} Hz)', color='orange')
    plt.title(f'Sampled Signal ({sr} Hz)')
    plt.xlabel('Time (s)')
    plt.ylabel('Amplitude')
    plt.grid(True)

plt.tight_layout()
plt.show()
