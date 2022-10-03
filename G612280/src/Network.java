import java.util.ArrayList;

public class Network {
	private static ArrayList<People> network;

	private Network() {
		network = new ArrayList<People>();
	}

	public static ArrayList<People> getNetwork() {
		if (network == null) network = new ArrayList<People>();
			return network;
	}
}
