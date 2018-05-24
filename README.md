For [JMH benchmark](http://openjdk.java.net/projects/code-tools/jmh/) run, because of the time that takes to run is a little bit long.
So, I recommend you should run only 1 benchmark file at a time.

Here are the steps you should do:
  * Comment out all the classes you do not want to run now (at this time)
  * From terminal : `./gradlew jmh`
  * Wait and take the results

Here are something about JMH, you can change in order to change the benchmark results

1. **`@Warmup`**

Those are iterations which are run just to invoke all standard processes in JVM i.e. 
JIT optimisations, GC markups. The results are ignored in the overall, final score. 
The amount of warmup iterations or time for each of them can be customized by Warmup annotation:

`@Warmup(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)`

* `iterations` – sets amount of warmup iterations for each benchmark
* `time` – sets how much time every warmup iteration will take in specified timeUnit
* `timeUnit` – almost every possible unit starting from TimeUnit.NANOSECONDS up to TimeUnit.DAYS (SI standard)
> This annotation is applicable for methods and for classes.

2. **`@Measurement`**

Those are iterations which really do matter in final results. Their amount is counted and summarized after all runs.
Parameters configuration is the same as for warmup iterations, except we use `@Measurement` annotation in here.

`@Measurement(batchSize = 1000000, iterations = 5)`
* `bactchSize`: Number of benchmark method calls per operation (This should use combine with `SingleShotTime` mode).
* `iteration` : Number of measurement iterations.
Ex: With about code: your benchmark method will call 5 operations, each operation 1000000 times

> This annotation is applicable for methods and for classes.

3. **`@Threads`**

Sets how many threads are concurrently executing benchmarks. Results are synchronized.

`@Threads(value = 4)`

> This annotation is applicable for methods and for classes.  

4. **`@BenchmarkMode`**

 Defines what do we really measure. 

`@BenchmarkMode(Mode.AverageTime)`

* `Mode.AverageTime`: Calculate an average running time. Runs by continuously calling Benchmark methods, 
counting the average time to call over all worker threads.
* `Mode.SingleShotTime`: Runs by calling Benchmark once and measuring its time. Simply, Benchmark methods
is called 1 time, full batch (input), and calculate the run time.
* `Mode.SampleTime`, `Mode.Throughput`, `Mode.All`: Please see more in [JMH docs](http://javadox.com/org.openjdk.jmh/jmh-core/0.8/org/openjdk/jmh/annotations/Mode.html)

> This annotation is applicable for methods and for classes.

5. **`OutputTimeUnit`**

The result output time format: MILLISECONDS, MICROSECONDS, SECONDS....

> This annotation is applicable for methods and for classes.

... 

Reference [JMH docs](http://javadox.com/org.openjdk.jmh/jmh-core/0.8/org/openjdk/jmh/annotations/Mode.html) and [this blog](https://blog.goyello.com/2017/06/19/testing-code-performance-jmh-tool/)
to learn more JMH annotations.
  
You can also improve by add more benchmark methods :)

**Happy coding!**
