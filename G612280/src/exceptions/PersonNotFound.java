package exceptions;

public class PersonNotFound extends RuntimeException{
    public PersonNotFound() {
        super();
    }
    public PersonNotFound(String message) {
        super(message);
    }
}
