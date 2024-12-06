package pl.arusoftware.research.patterns.result;

public record NotFoundError(String message) implements GenericError {
}
