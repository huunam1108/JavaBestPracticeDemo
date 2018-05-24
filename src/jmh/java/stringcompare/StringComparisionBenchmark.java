package stringcompare;

import org.openjdk.jmh.annotations.*;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@Measurement(batchSize = 1000000, iterations = 1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(5)
public class StringComparisionBenchmark {
    private String string1;
    private String string2;
    private String string3;
    private String string4;
    private String string5;
    private String string6;

    @Setup(Level.Iteration)
    public void setUp() {
        string1 = "H" + "elloWorld";
        string2 = "HelloWorl" + "d";

        string3 = "HelloWorld";
        string4 = "HelloWorlD";

        string5 = "HelloWorld";
        string6 = "HelloWorld1";
    }

    @Benchmark
    public boolean equals1() {
        return string1.equals(string2);
    }

    @Benchmark
    public boolean equals2() {
        return string3.equals(string4);
    }


    @Benchmark
    public boolean equals3() {
        return string5.equals(string6);
    }

    @Benchmark
    public boolean equalsIgnoreCase1() {
        return string1.equalsIgnoreCase(string2);
    }

    @Benchmark
    public boolean equalsIgnoreCase2() {
        return string3.equalsIgnoreCase(string4);
    }


    @Benchmark
    public boolean equalsIgnoreCase3() {
        return string5.equalsIgnoreCase(string6);
    }


    @Benchmark
    public boolean objectEquals1() {
        return Objects.equals(string1, string2);
    }

    @Benchmark
    public boolean objectEquals2() {
        return Objects.equals(string3, string4);
    }


    @Benchmark
    public boolean objectEquals3() {
        return Objects.equals(string5, string6);
    }
}
