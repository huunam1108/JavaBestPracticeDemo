package collection;


import org.openjdk.jmh.annotations.*;
import util.Utils;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static util.Utils.ListType.COPY_ON_WRITE_ARRAY_LIST;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ListsBenchmark {
    private static final int BATCH_SIZE = 1000000;
    private static final Random random = new Random();
    private int randomNumber;
    @Param({"ARRAY_LIST",
            "LINKED_LIST",
            "COPY_ON_WRITE_ARRAY_LIST"})
    private Utils.ListType listType;
    private List<Integer> benchMarkList;
    private List<Integer> emptyList;

    @Setup(Level.Iteration)
    public void setUp() {
        if (listType == COPY_ON_WRITE_ARRAY_LIST) {
            randomNumber = random.nextInt(1000);
            benchMarkList = Utils.fillListData(listType, 1000);
        } else {
            randomNumber = random.nextInt(BATCH_SIZE);
            benchMarkList = Utils.fillListData(listType);
        }
        emptyList = Utils.fillListData(listType, 0);
        System.out.println("ListType: " + listType);
    }

    @Benchmark
    @Fork(1)
    @Measurement(iterations = 5)
    @BenchmarkMode(Mode.AverageTime)
    public boolean add() {
        return emptyList.add(0);
    }

    @Benchmark
    @Measurement(batchSize = BATCH_SIZE, iterations = 1)
    @BenchmarkMode(Mode.SingleShotTime)
    @Fork(5)
    public int size() {
        return benchMarkList.size();
    }

    @Benchmark
    @Fork(1)
    @Measurement(iterations = 5)
    @BenchmarkMode(Mode.AverageTime)
    public Integer get() {
        return benchMarkList.get(randomNumber);
    }

    @Benchmark
    @Fork(1)
    @Measurement(iterations = 5)
    @BenchmarkMode(Mode.AverageTime)
    public Integer remove() {
        return benchMarkList.remove(0);
    }

    @Benchmark
    @Fork(1)
    @Measurement(iterations = 5)
    @BenchmarkMode(Mode.AverageTime)
    public boolean contains() {
        return benchMarkList.contains(randomNumber);
    }

    @Benchmark
    @Fork(1)
    @Measurement(iterations = 5)
    @BenchmarkMode(Mode.AverageTime)
    public int next() {
        Iterator<Integer> iterator = benchMarkList.iterator();
        int last = 0;
        while (iterator.hasNext()) {
            last = iterator.next();
        }
        return last;
    }

    /*

    List                 | Add  | Remove | Get  | Contains | Next | Size |
    ---------------------|------|--------|------|----------|------|------|
    ArrayList            | O(1) |  O(n)  | O(1) |   O(n)   | O(1) | O(1) |
    LinkedList           | O(1) |  O(1)  | O(n) |   O(n)   | O(1) | O(1) |
    CopyOnWriteArrayList | O(n) |  O(n)  | O(1) |   O(n)   | O(1) | O(1) |

    */
}
