package pl.arusoftware.research.patterns.result;

public final class Result<T> {
    private final T data;
    private final GenericError error;
    private final boolean isSuccess;

    private Result(T data, boolean isSuccess, GenericError error) {
        this.data = data;
        this.isSuccess = isSuccess;
        this.error = error;
    }

    public static <T> Result<T> onSuccess(T data) {
        return new Result<>(data, true, null);
    }

    public static <T> Result<T> onFailure(GenericError error) {
        return new Result<>(null, false, error);
    }

    public T getData() {
        return data;
    }

    public GenericError getError() {
        return error;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
