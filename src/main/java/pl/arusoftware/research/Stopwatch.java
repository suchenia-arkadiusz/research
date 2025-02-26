package pl.arusoftware.research;

public class Stopwatch {
    private double startNanos;

    public Stopwatch() {
        reset();
    }

    public void reset() {
        startNanos = System.nanoTime() * 1.0;
    }

    public double getTimeInNanos() {
        return System.nanoTime() - startNanos;
    }

    public double getTimeInMillis() {
        return getTimeInNanos() / 1_000_000.0;
    }

    public double getTimeInSeconds() {
        return getTimeInMillis() / 1_000.0;
    }
}
