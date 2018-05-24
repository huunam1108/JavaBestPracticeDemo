package collection;


import org.openjdk.jmh.annotations.*;
import util.Utils;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static util.Utils.SetType.COPY_ON_WRITE_ARRAY_SET;

@State(Scope.Thread)
@Fork(1)
@Measurement(iterations = 5)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class SetsBenchmark {
    private static final int BATCH_SIZE = 1000000;
    private static final Random random = new Random();
    private int randomNumber;
    @Param({"HASH_SET",
            "LINKED_HASH_SET",
            "TREE_SET",
            "COPY_ON_WRITE_ARRAY_SET",
            "CONCURRENT_SKIP_LIST_SET"})
    private Utils.SetType setType;
    private Set<Integer> benchMarkSet;
    private Set<Integer> emptySet;

    @Setup(Level.Iteration)
    public void setUp() {
        if (setType == COPY_ON_WRITE_ARRAY_SET) {
            randomNumber = random.nextInt(10000);
            benchMarkSet = Utils.fillSetData(setType, 10000);
        } else {
            randomNumber = random.nextInt(BATCH_SIZE);
            benchMarkSet = Utils.fillSetData(setType);
        }
        emptySet = Utils.fillSetData(setType, 0);
        System.out.println("SetType: " + setType);
    }

    @Benchmark
    public void add() {
        emptySet.add(0);
    }

    @Benchmark
    public int size() {
        return benchMarkSet.size();
    }

    @Benchmark
    public boolean remove() {
        return benchMarkSet.remove(0);
    }

    @Benchmark
    public boolean contains() {
        return benchMarkSet.contains(randomNumber);
    }

    @Benchmark
    public int next() {
        Iterator<Integer> iterator = benchMarkSet.iterator();
        int next = 0;
        if (iterator.hasNext()) {
            next = iterator.next();
        }
        return next;
    }

    /*
    Set                   |    Add   |  Remove  | Contains |   Next   | Size |
    ----------------------|----------|----------|----------|----------|------|
    HashSet               | O(1)     | O(1)     | O(1)     | O(h/n)   | O(1) |
    LinkedHashSet         | O(1)     | O(1)     | O(1)     | O(1)     | O(1) |
    TreeSet               | O(log n) | O(log n) | O(log n) | O(log n) | O(1) |
    CopyOnWriteArraySet   | O(n)     | O(n)     | O(n)     | O(1)     | O(1) |
    ConcurrentSkipListSet | O(log n) | O(log n) | O(log n) | O(1)     | O(n) |
    */
}
