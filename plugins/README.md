# Running the experiments

## Preparing the environment

### Pre-requisites

1. *TemporalEMF* is based on EMF 2.13 and Eclipse Oxygen, and as such, requires **Java 8 or higher**.

1. The experiments have been designed to be executed in an unnatended way using **Ant**.

3. It is necessary to have a separate installation of **HBase** (see https://hbase.apache.org/book.html#standalone_dist), that can be used as the persistence storage.

**NOTE:** The experiments have been executed under Linux. Shell scripts are only provided in their bash variant.

### Preparing the environment

First, it is necessary to clone the current repository to get all the sources:

```
shell$ git clone https://github.com/SOM-Research/temporal-emf-benchmarks.git
shell$ cd temporal-emf-benchmarks/plugins
```

Second, it is necessary to download *TemporalEMF* with all its dependencies. Although a full eclipse installation is not required, the easiest way to do get a working *TemporalEMF* installation  is to use the `install-eclipse-oxygen-x86_64.sh` script. This will download and install Eclipse Oxygen with *TemporalEMF* in an unattended way in the current working dir:

```
shell$ ./install-eclipse-oxygen-x86_64.sh
************************************************************
Checking previous installations...
Getting installation package...
######################################################################## 100.0%
Extracting...
Configuring (this may take a while, please be patient)...
Installing org.apache.hadoop.hbase.feature.feature.group 1.2.6.201803071856.
Installing edu.uoc.som.temf.feature.feature.group 0.1.0.201804262009.
Installing org.eclipse.emf.sdk.feature.group 2.13.0.v20170609-0928.
Operation completed in 90690 ms.
Configurations finished
Installing...
Done
************************************************************
shell$
```

Third, the simulation parameters and configuration can be set in the `config.properties` file:

```
eclipse.home=../eclipse-oxygen/
sim.vmargs=-Xmx2g -Djava.util.logging.config.file=log.properties -Duser.country=US -Duser.language=en
env.hbase.server=127.0.0.1
env.tll.memory.period=20000
env.tll.iterations.period=20000
```

Update the file according to your system and preferences, where:

* `eclipse.home` is the directory where the full eclipse installation can be found.
* `sim.vmargs` contains the VM parameters. Here it is important to the the proper log.properties file, in order to get the runtime data.
* `env.hbase.server` should contain the IP (and port if a non-standard port is used) of the HBase server.
* `env.tll.memory.period` period, in milliseconds, between log entries with the memory usage.
* `env.tll.iterations.period` period, in milliseconds, between log entries with the iteration being executed.

### Running the experiments

Once the environment has been set up, the experiments can be executed using **ant** from within the `plugins/edu.uoc.som.tll.simulation` directory.
The basic build tasks and dependencies configuration are found in the `build.manual.xml` file.
The tasks related with the experiments are found in the `run-experiments.xml` build file.

The task `gen.instances` allows to create the test instances for different model simulations, logging levels, and processing times, see `run-experiments.xml` for more details.

E.g., to generate the instances from 20 to 320 iterations, with a processing time of 0 and 5 ms, and for *TemporalEMF* and *StandardEMF* the following `gen.instances` task can be used:

```
<target name="gen.instances">
  <mkdir dir="${instances.dir}" />
  <for list="00020,00040,00080,00160,00320" param="iterations">
    <sequential>
      <for list="00,05" param="delay">
        <sequential>
          <for list="fullhistory,nohistory" param="variant">
            <sequential>
              <xmltask source="test-instances/singlearea-@{variant}.xmi" dest="${instances.dir}/singlearea-@{variant}-@{delay}-@{iterations}.xmi">
                <attr path="//component" attr="processingTime" value="@{delay}" />
                <attr path="//simconfig" attr="iterations" value="@{iterations}" />
              </xmltask>
            </sequential>
          </for>
        </sequential>
      </for>
    </sequential>
  </for>
</target>
```

The generation can be triggered as shown below. The instances will be generated inside the `benchmark-instances` directory.

```
shell$ ant -f build.manual.xml gen.instances
```

The simulation can be executed in several ways:

1. Running all experiments from ant (`sim.xmi` and `sim.temf` target also exist):

```
shell$ ant -f build.manual.xml sim
```


2. Model by model, from ant, by creating/updating the specific ant target (See the `sim.xmi.middle` in `run-experiments.xml` for an example). E.g.:

```
shell$ ant -f build.manual.xml sim.xmi.middle
```

where:

```
<target depends="build" name="sim.xmi.middle">
  <antcall target="sim.xmi.file">
    <param name="file" value="test-instances/IAFPlantMultiArea_middle.xmi"/>
  </antcall>
</target>
```


3. Model by model, directly from the shell (useful to do additional tasks -- such as changing dirs, keeping logs or notify via e-mail -- within an additional shell script):

```
shell$ ant -f build.manual.xml build sim.xmi.file.cli -Dinput.file=benchmark-instances/singlearea-fullhistory-00-00020.xmi
```

For each simulation, a directory matching the input model name will be created with all the logs colleted during the execution of the experiment.
