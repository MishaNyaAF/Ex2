package Mishaniy.entity;

public class Raw {
    private Response response;

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

    @Override
    public String toString() {
        return "Raw{" +
                "response=" + response +
                '}';
    }
}
