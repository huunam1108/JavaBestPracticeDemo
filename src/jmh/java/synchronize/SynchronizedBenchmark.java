package synchronize;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@Threads(2) // Edit this threads number
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1)
@Measurement(iterations = 5)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(1)
public class SynchronizedBenchmark {
    private int count;

    @Setup(Level.Iteration)
    public void setUp() {
    }

    @Benchmark
    public synchronized void sync() {
        synchronized (SynchronizedBenchmark.class) {
            increase();
        }
    }


    @Benchmark
    public void noSync() {
        increaseWithoutSync();
    }

    private void increase() {
        count++;
    }

    private void increaseWithoutSync() {
        count++;
    }
}
