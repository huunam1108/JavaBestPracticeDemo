package collection;


import org.openjdk.jmh.annotations.*;
import util.Utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MapsBenchmark {
    private static final int BATCH_SIZE = 1000000;
    private static final Random random = new Random();
    private int randomNumber;
    @Param({"HASH_MAP",
            "LINKED_HASH_MAP",
            "IDENTITY_HASH_MAP",
            "WEAK_HASH_MAP",
            "TREE_MAP",
            "CONCURRENT_HASH_MAP",
            "CONCURRENT_SKIP_HASH_MAP"})
    private Utils.MapType mapType;
    private Map<Integer, Integer> benchMarkMap;
    private int callTime = 0;

    @Setup(Level.Iteration)
    public void setUp() {
        randomNumber = random.nextInt(BATCH_SIZE);
        benchMarkMap = Utils.fillMapData(mapType);
        System.out.println("mapType: " + mapType + " + " + callTime);
        callTime = 0;
    }

    @Benchmark
    @Measurement(batchSize = BATCH_SIZE, iterations = 1)
    @BenchmarkMode(Mode.SingleShotTime)
    @Fork(5)
    public Integer get() {
        return benchMarkMap.get(randomNumber);
    }

    @Benchmark
    @Measurement(batchSize = BATCH_SIZE, iterations = 1)
    @BenchmarkMode(Mode.SingleShotTime)
    @Fork(5)
    public boolean containsKey() {
        return benchMarkMap.containsKey(randomNumber);
    }

    @Benchmark
    @Fork(1)
    @Measurement(iterations = 5)
    @BenchmarkMode(Mode.AverageTime)
    public Integer next() {
        callTime++;
        int key = 0;
        Iterator<Map.Entry<Integer, Integer>> it = benchMarkMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = it.next();
            key = pair.getKey();
        }
        return key;
    }

    /*
    Map                   |   Get    | ContainsKey |   Next   |
    ----------------------|----------|-------------|----------|
    HashMap               | O(1)     |   O(1)      | O(h / n) |
    LinkedHashMap         | O(1)     |   O(1)      | O(1)     |
    IdentityHashMap       | O(1)     |   O(1)      | O(h / n) |
    WeakHashMap           | O(1)     |   O(1)      | O(h / n) |
    TreeMap               | O(log n) |   O(log n)  | O(log n) |
    ConcurrentHashMap     | O(1)     |   O(1)      | O(h / n) |
    ConcurrentSkipListMap | O(log n) |   O(log n)  | O(1)     |
    */
}