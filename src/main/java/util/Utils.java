package util;

import java.util.*;
import java.util.concurrent.*;

public class Utils {
    private static final int FIXED_SIZE = 1000000;

    public enum ListType {
        ARRAY_LIST,
        LINKED_LIST,
        COPY_ON_WRITE_ARRAY_LIST
    }

    public enum SetType {
        HASH_SET,
        LINKED_HASH_SET,
        TREE_SET,
        COPY_ON_WRITE_ARRAY_SET,
        CONCURRENT_SKIP_LIST_SET
    }

    public enum QueueType {
        PRIORITY_QUEUE,
        LINKED_LIST,
        ARRAY_DEQUE,
        CONCURRENT_LINKED_QUEUE,
        CONCURRENT_LINKED_DEQUE,
        PRIORITY_BLOCKING_QUEUE,
        SYNCHRONOUS_QUEUE,
        LINKED_BLOCKING_QUEUE,
        LINKED_BLOCKING_DEQUE
    }

    public enum MapType {
        HASH_MAP,
        LINKED_HASH_MAP,
        IDENTITY_HASH_MAP,
        WEAK_HASH_MAP,
        TREE_MAP,
        CONCURRENT_HASH_MAP,
        CONCURRENT_SKIP_HASH_MAP;
    }

    public static List<Integer> fillListData(ListType listType) {
        return fillListData(listType, FIXED_SIZE);
    }

    public static List<Integer> fillListData(ListType listType, int size) {
        List<Integer> result;
        switch (listType) {
            case ARRAY_LIST:
                result = new ArrayList<>();
                break;
            case LINKED_LIST:
                result = new LinkedList<>();
                break;
            case COPY_ON_WRITE_ARRAY_LIST:
            default:
                result = new CopyOnWriteArrayList<>();
                break;
        }
        for (int i = 0; i < size; i++) {
            result.add(i);
        }
        return result;
    }

    public static Set<Integer> fillSetData(SetType setType) {
        return fillSetData(setType, FIXED_SIZE);
    }

    public static Set<Integer> fillSetData(SetType setType, int size) {
        Set<Integer> result;
        switch (setType) {
            case HASH_SET:
                result = new HashSet<>();
                break;
            case LINKED_HASH_SET:
                result = new LinkedHashSet<>();
                break;
            case TREE_SET:
                result = new TreeSet<>();
                break;
            case CONCURRENT_SKIP_LIST_SET:
                result = new ConcurrentSkipListSet<>();
                break;
            case COPY_ON_WRITE_ARRAY_SET:
            default:
                result = new ConcurrentSkipListSet<>();
                break;
        }
        for (int i = 0; i < size; i++) {
            result.add(i);
        }
        return result;
    }

    public static Queue<Integer> fillQueueData(QueueType queueType) {
        Queue<Integer> result;
        switch (queueType) {
            case PRIORITY_QUEUE:
                result = new PriorityQueue<>();
                break;
            case LINKED_LIST:
                result = new LinkedList<>();
                break;
            case ARRAY_DEQUE:
                result = new ArrayDeque<>();
                break;
            case CONCURRENT_LINKED_QUEUE:
                result = new ConcurrentLinkedQueue<>();
                break;
            case CONCURRENT_LINKED_DEQUE:
                result = new ConcurrentLinkedDeque<>();
                break;
            case PRIORITY_BLOCKING_QUEUE:
                result = new PriorityBlockingQueue<>();
                break;
            case SYNCHRONOUS_QUEUE:
                result = new SynchronousQueue<>();
                break;
            case LINKED_BLOCKING_QUEUE:
                result = new LinkedBlockingQueue<>();
                break;
            case LINKED_BLOCKING_DEQUE:
            default:
                result = new LinkedBlockingDeque<>();
                break;
        }
        for (int i = 0; i < FIXED_SIZE; i++) {
            result.add(i);
        }
        return result;
    }

    public static Map<Integer, Integer> fillMapData(MapType mapType) {
        Map<Integer, Integer> result;
        switch (mapType) {
            case HASH_MAP:
                result = new HashMap<>();
                break;
            case LINKED_HASH_MAP:
                result = new LinkedHashMap<>();
                break;
            case IDENTITY_HASH_MAP:
                result = new IdentityHashMap<>();
                break;
            case WEAK_HASH_MAP:
                result = new WeakHashMap<>();
                break;
            case TREE_MAP:
                result = new TreeMap<>();
                break;
            case CONCURRENT_HASH_MAP:
                result = new ConcurrentHashMap<>();
                break;
            case CONCURRENT_SKIP_HASH_MAP:
            default:
                result = new ConcurrentSkipListMap<>();
                break;
        }
        for (int i = 0; i < FIXED_SIZE; i++) {
            result.put(i, i);
        }
        return result;
    }
}
