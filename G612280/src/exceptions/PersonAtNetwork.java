package exceptions;

public class PersonAtNetwork extends RuntimeException{
    public PersonAtNetwork() {
        super();
    }
    public PersonAtNetwork(String message) {
        super(message);
    }
}
