package exceptions;

public class IncorrectSkinName extends RuntimeException {
    private String message;

    public IncorrectSkinName(String message) {
        super(message);
        this.message = message;
        System.out.println(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
