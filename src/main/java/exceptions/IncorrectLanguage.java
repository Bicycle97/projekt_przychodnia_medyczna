package exceptions;

public class IncorrectLanguage extends RuntimeException {

    private String message;

    public IncorrectLanguage(String message) {
        super(message);
        this.message = message;
        System.out.println(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

}
