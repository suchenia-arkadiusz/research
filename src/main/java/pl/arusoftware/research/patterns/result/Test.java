package pl.arusoftware.research.patterns.result;

import pl.arusoftware.research.ResearchResult;
import pl.arusoftware.research.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    private static final Stopwatch stopwatch = new Stopwatch();

    public static void main(String[] args) {
        long[] limits = new long[]{1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000};
        for (long limit : limits) {
            runTest(limit);
        }
    }

    private static void runTest(long limit) {
        stopwatch.reset();
        testResult(limit);
        double resultExecutionTimeInNanos = stopwatch.getTimeInNanos();

        stopwatch.reset();
        testException(limit);
        double exceptionExecutionTimeInNanos = stopwatch.getTimeInNanos();


        ResearchResult researchResult = new ResearchResult(Map.of(
                "resultPattern", resultExecutionTimeInNanos,
                "exception", exceptionExecutionTimeInNanos
        ), limit);
        System.out.println(researchResult);
    }

    private static void testResult(long limit) {
        List<Result<String>> results = new ArrayList<>();
        for (long i = 0; i < limit; i++) {
            Result<String> result = generateResult();
            results.add(result);
            if (result.isSuccess()) {
                // do something
            } else {
                // do something
            }
        }
    }

    private static Result<String> generateResult() {
        return Result.onFailure(new NotFoundError("Not Found"));
    }

    private static void testException(long limit) {
        for (long i = 0; i < limit; i++) {
            try {
                generateSomething();
            } catch (Exception e) {
                // do something
            }
        }
    }

    private static void generateSomething() throws Exception {
        throw new Exception("Not Found");
    }
}
