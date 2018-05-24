package collection;


import org.openjdk.jmh.annotations.*;
import util.Utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@Measurement(batchSize = 1000000, iterations = 1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(5)
public class QueueBenchmark {
    private static final Random random = new Random();
    private int randomNumber;
    @Param(value = {"PRIORITY_QUEUE",
            "LINKED_LIST",
            "ARRAY_DEQUE",
            "CONCURRENT_LINKED_QUEUE",
            "CONCURRENT_LINKED_DEQUE",
            "PRIORITY_BLOCKING_QUEUE",
            "SYNCHRONOUS_QUEUE",
            "LINKED_BLOCKING_QUEUE",
            "LINKED_BLOCKING_DEQUE"})
    private Utils.QueueType queueType;
    private Queue<Integer> benchMarkQueue;

    @Setup(Level.Iteration)
    public void setUp() {
        randomNumber = random.nextInt(1000000);
        benchMarkQueue = Utils.fillQueueData(queueType);
        System.out.println("queueType: " + queueType);
    }

    @Benchmark
    public void queueOffer() {
        benchMarkQueue.offer(randomNumber);
    }

    @Benchmark
    public int queuePeek() {
        return benchMarkQueue.peek();
    }

    @Benchmark
    public Integer queuePoll() {
        return benchMarkQueue.poll();
    }

    @Benchmark
    public boolean queueRemove() {
        if (benchMarkQueue instanceof LinkedList) {
            return benchMarkQueue.remove(randomNumber);
        }
        // This method take too much time to execute with Queue
        return false;
    }

    @Benchmark
    public int queueSize() {
        if (benchMarkQueue instanceof ConcurrentLinkedDeque || benchMarkQueue instanceof ConcurrentLinkedQueue) {
            // This method take too much time to execute with ConcurrentLinkedQueue or ConcurrentLinkedDeque
            return 1;
        }
        return benchMarkQueue.size();
    }

    /*
    Queue                   |  Offer   | Peek |   Poll   | Remove | Size |
    ------------------------|----------|------|----------|--------|------|
    PriorityQueue           | O(log n) | O(1) | O(log n) |  O(n)  | O(1) |
    LinkedList              | O(1)     | O(1) | O(1)     |  O(1)  | O(1) |
    ArrayDeque              | O(1)     | O(1) | O(1)     |  O(n)  | O(1) |
    ConcurrentLinkedQueue   | O(1)     | O(1) | O(1)     |  O(n)  | O(n) |
    ConcurrentLinkedDeque   | O(1)     | O(1) | O(1)     |  O(n)  | O(n) |
    PriorityBlockingQueue   | O(log n) | O(1) | O(log n) |  O(n)  | O(1) |
    SynchronousQueue        | O(1)     | O(1) | O(1)     |  O(n)  | O(1) |
    LinkedBlockingQueue     | O(1)     | O(1) | O(1)     |  O(n)  | O(1) |
    LinkedBlockingDeque     | O(1)     | O(1) | O(1)     |  O(n)  | O(1) |
    */
}
