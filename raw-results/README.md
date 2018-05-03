# *TemporalEMF* Benchmarks Results

# Repository contents:

## Directories

* `Xmx2g.exectime`: Execution time for both *TemporalEMF* and *StandardEMF*, using a heap limited to 2 GB.
* `Xmx2g.memory`: Memory used by both *TemporalEMF* and *StandardEMF*, using a heap limited to 2 GB.
* `Xmx512g.memory`: Memory used by both *TemporalEMF* and *StandardEMF*, using a heap limited to 512 MB.

## Scripts

* `gather-exec-times.sh`: Script that analyzes the logs and extracts the total execution time of a simulation, generates `*.dat` files and  produces the corresponding plots.

* `gather-memory-consumption.sh`: Script extracting the occupied memory from the execution logs (which contain the memory usage at regular intervals -- 20 seconds). Two kind of plots are produced: first, the used memory (Y axis) in function of time (X axis); and second, the used memory (Y axis) in function of the iteration number (X axis). The second kind of plots is created to avoid the throughput to interfere in the results.

* `gather-iterations-time.sh`: Script calculating (both as data and as a graphic plot) the number of itereations executed per unit of time (20 seconds). This is used to confirm that the throughput varies during time.

* `gather-final-memory-consumption.sh`: Script that obtains the memory consumption before and after saving the Resource containing the simulated model both as data (`*.dat`) and as a graphic plot (`*.png`). The occupied memory is measured after requesting the *Garbage Collector* for three times.

* `gather-query-times.sh`: Script that analyzes the logs and extracts the execution times of queries, and generates a `querytime.dat` file.

All the scripts above must be executed from any of the directories listed at the begining of this page (i.e., the directory directly containing the results for a given set of experiments). E.g.:

```
shell$ pushd Xmx2g.exectime
shell$ ../gather-exec-times.sh
shell$ popd
```