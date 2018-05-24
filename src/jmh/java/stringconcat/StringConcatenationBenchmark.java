package stringconcat;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1)
@Measurement(iterations = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(1)
public class StringConcatenationBenchmark {
    private static final String ADDED_STRING = "Some More Data";
    private String string;
    private String stringConcat;
    private StringBuilder stringBuilder;
    private StringBuffer stringBuffer;

    @Setup(Level.Iteration)
    public void setUp() {
        string = "";
        stringConcat = "";
        stringBuilder = new StringBuilder();
        stringBuffer = new StringBuffer();
    }

    @Benchmark
    public void stringPlus() {
        string += ADDED_STRING;
    }

    @Benchmark
    public void stringConcat() {
        stringConcat = stringConcat.concat(ADDED_STRING);
    }

    @Benchmark
    public void stringBuilderConcatenation() {
        try {
            stringBuilder.append(ADDED_STRING);
        } catch (OutOfMemoryError error) {
            stringBuilder = new StringBuilder();
        }
    }

    @Benchmark
    public void stringBufferConcatenation() {
        try {
            stringBuffer.append(ADDED_STRING);
        } catch (OutOfMemoryError error) {
            stringBuffer = new StringBuffer();
        }
    }
}
