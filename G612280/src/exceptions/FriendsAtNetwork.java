package exceptions;

public class FriendsAtNetwork extends RuntimeException{
    public FriendsAtNetwork() {
        super();
    }
    public FriendsAtNetwork(String message) {
        super(message);
    }
}
