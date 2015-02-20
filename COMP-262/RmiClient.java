import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RmiClient {

	public static void main(String[] args) {
		try{
			
			Registry registry= LocateRegistry.getRegistry("10.15.4.69");
			RmiInterface rmi=(RmiInterface)registry.lookup("bilgi");
			System.out.println("Severden gelen "+rmi.merhaba());
			
		}
		catch( Exception e){
			System.out.println("Rmi Client error....");
			System.out.println(e.toString());
		}
	}
}
