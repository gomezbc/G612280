package exceptions;

public class RelationNotExist extends RuntimeException{
    public RelationNotExist() {
        super();
    }
    public RelationNotExist(String message) {
        super(message);
    }
}
