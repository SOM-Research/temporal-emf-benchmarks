# Memory Usage and Query Time - 512MB eap

## Contents:

* Directory `benchmark-instances`: Instances used for the simulations.

* Directories `memory-singlearea-fullhistory-00-<iterations>`: Directoty with the execution logs for the simulations with varying *iterations* for *StandardEMF* (*processing time* is set to 0, since we are not measuring execution time, and want to run the simulation as fast as possible.).

* Directories `memory-singlearea-fullhistory-00-<iterations>`: Directoty with the execution logs for the simulations with varying *iterations* for *TemporalEMF* (*processing time* is set to 0, since we are not measuring execution time, and want to run the simulation as fast as possible.).

* Files `memorytime-<iterations>.dat`: Files with the memory used in at regular intervals (in the current experiments, every 20 seconds).

* Files `memorytime-<iterations>.png`: Plot files generated from the corresponding `memorytime-<iterations>.dat` files.

* Files `memoryiterations-<iterations>.dat`: Files with the memory used and the closest iteration number (the one with the closest timestamp). Both timestamps (when the memory usage was logged and when the iteration was logged) are also included.

* Files `memoryiterations-<iterations>.png`: Plot files generated from the corresponding `memoryiterations-<iterations>.dat` files.

* Files `iterationstime-<iterations>.dat`: Number of iterations of the simulation that were executed per unit of time (i.e., every 20 seconds). Used to measure the throughput.

* Files `iterationstime-<iterations>.png`: Plot files generated from the corresponding `iterationstime-<iterations>.dat` files.

* File `simmemory.dat`: Memory usage after the simulation. Memory consumption is measured before and after saving the Resource containing the simulated model, and after requesting the Garbage Collector for three times.

* Files `simmemory.png`: Plot generated from `simmemory.dat`.

* File `querytime.dat`: Execution times for the queries Q1-Q4.


## Results

**NOTE:** Only plots for more than 10240 are shown below, since logs for shorter simulations do not contain enough data.

### 10240 iterations

![](memorytime-0010240.png)
![](memoryiterations-0010240.png)
![](iterationstime-0010240.png)

### 20480 iterations

![](memorytime-0020480.png)
![](memoryiterations-0020480.png)
![](iterationstime-0020480.png)

### 40960 iterations

![](memorytime-0040960.png)
![](memoryiterations-0040960.png)
![](iterationstime-0040960.png)

### 81920 iterations

![](memorytime-0081920.png)
![](memoryiterations-0081920.png)
![](iterationstime-0081920.png)

### 163840 iterations

![](memorytime-0163840.png)
![](memoryiterations-0163840.png)
![](iterationstime-0163840.png)

### 327680 iterations

![](memorytime-0327680.png)
![](memoryiterations-0327680.png)
![](iterationstime-0327680.png)

### Final memory usage

Memory usage after running the simulation (X Axis = number of iterations; Y Axis = Ocuppied memory before/after saving into disk).

![](simmemory.png)

### Query execution times

See [querytime.dat](querytime.dat)

