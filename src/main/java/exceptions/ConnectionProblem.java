package exceptions;

public class ConnectionProblem extends RuntimeException {
    private String message;

    public ConnectionProblem(String message) {
        super(message);
        this.message = message;
        System.out.println(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
