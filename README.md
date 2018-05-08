# *TemporalEMF* Benchmarks

Repository contents:

* Go to [`plugins`](plugins/) to inspect the sources of the simulator and the test code.
* Go to [`raw-results`](raw-results/) to inspect the execution logs, `*.dat` files generated from them, and the plots generated with `gnuplot`.


# Questions

This study aims to evaluate the possible distinct behavior of current in-memory solutions without dedicated temporal support (what we will call *StandardEMF*) and our temporal solution (*TemporalEMF*). Specifically, we aim to answer the following questions:

**RQ1**: Is there a significant difference of the time required for producing and manipulating temporal model elements? 

**RQ2**: Is there a significant difference in the memory used and the storage size of temporal models? 

**RQ3**: Is there a significant difference of restoring previous versions of temporal model elements? For an implementation of the queries used to evaluate this (Q1-Q4), please check  [`plugins/edu.uoc.som.tll.simulation/src/test/SimulateXmi.java`](plugins/edu.uoc.som.tll.simulation/src/test/SimulateXmi.java) and [`plugins/edu.uoc.som.tll.simulation/src/test/SimulateTemf.java`](plugins/edu.uoc.som.tll.simulation/src/test/SimulateTemf.java).



# Models

In all the experiments we have used a model with a single *System* and varying *SimConfig* parameters. The base model is available in [`plugins/edu.uoc.som.tll.simulation/test-instances/singlearea-fullhistory.xmi`](plugins/edu.uoc.som.tll.simulation/test-instances/singlearea-fullhistory.xmi) for *StandardEMF* and [`plugins/edu.uoc.som.tll.simulation/test-instances/singlearea-nohistory.xmi`](plugins/edu.uoc.som.tll.simulation/test-instances/singlearea-nohistory.xmi) for *TemporalEMF*.

Based on the parameters on the table below, we created the instances available for the different experiments. These test instances are available in [`raw-results/Xmx2g.exectime/benchmark-instances`](raw-results/Xmx2g.exectime/benchmark-instances), [`raw-results/Xmx2g.memory/benchmark-instances`](raw-results/Xmx2g.memory/benchmark-instances), and [`raw-results/Xmx512m.memory/benchmark-instances`](raw-results/Xmx512m.memory/benchmark-instances).


| RQ  |               Processing Time          |            Iterations          |   Java Heap   |
|-----|----------------------------------------|--------------------------------|---------------|
| RQ1 | 0 ms -- 40 ms (common difference +5ms) | 20 -- 40960 (common ratio  x2) | 2 GB          |
| RQ2 | 0 ms                                   | 20 -- 655360 (common ratio x2) | 512 MB & 2 GB |
| RQ3 | 0 ms                                   | 20 -- 655360 (common ratio x2) | 512 MB & 2 GB |


# Results

From the experiments listed above, a set of **numerical data** and **graphs** has been gathered and produced for an easy interpretation of results.
For a better organization, these results have been included in their corresponding subfolders, together with the raw data:

* For RQ1 see [`raw-results/Xmx2g.exectime/README.md`](raw-results/Xmx2g.exectime/README.md),
* For RQ2 and RQ3 see [`raw-results/Xmx2g.memory/README.md`](raw-results/Xmx2g.memory/README.md), and [`raw-results/Xmx512m.memory/README.md`](raw-results/Xmx512m.memory/README.md).
