package Mishaniy.entity;

public class ErrorU {
    private int error_code;

    public ErrorU(int error_code) {
        this.error_code = error_code;
    }

    public ErrorU() {
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    @Override
    public String toString() {
        return "ErrorU{" +
                "error_code=" + error_code +
                '}';
    }
}
