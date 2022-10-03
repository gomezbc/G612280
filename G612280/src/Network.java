import java.util.ArrayList;

public class Network {
	//Implementar el singelton igual
	private static ArrayList<People> network;

	private Network() {
		network = new ArrayList<People>();
	}

	public static ArrayList<People> getNetwork() {
		if (network == null) {
			network = new ArrayList<People>();
		}else{
			return network;
		}
	}
}
