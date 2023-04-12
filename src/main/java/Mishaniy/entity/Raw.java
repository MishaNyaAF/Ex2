package Mishaniy.entity;

public class Raw {
    private Response response;
    private ErrorU errorU;

    public Raw() {
    }

    public Raw(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public ErrorU getErrorU() {
        return errorU;
    }

    public void setErrorU(ErrorU errorU) {
        this.errorU = errorU;
    }

    @Override
    public String toString() {
        return "Raw{" +
                "response=" + response +
                '}';
    }
}
