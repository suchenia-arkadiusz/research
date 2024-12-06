package pl.arusoftware.research;

import java.util.Map;

public record ResearchResult(Map<String, Long> values, long limit) {
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{\n\tlimit: ").append(limit).append(",\n\tvalues: [");
        values.forEach((key, value) -> builder.append("\n\t\t\"").append(key).append("\": ").append(value).append(","));
        builder.append("\n\t]\n}");

        return builder.toString();
    }
}
