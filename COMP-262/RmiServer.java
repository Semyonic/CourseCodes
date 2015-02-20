import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.omg.CORBA.portable.RemarshalException;


public class RmiServer implements RmiInterface {

	 public String merhaba()throws RemoteException{
		 return "Merhaba";
	 }
	 
	 public static void main(String[] args) {
		try{
			
			RmiServer server= new RmiServer();
			RmiInterface paylas=(RmiInterface)UnicastRemoteObject.exportObject(server,0);
			Registry regist= LocateRegistry.getRegistry();
			regist.rebind("bilgi", paylas);
			
			System.out.println("Rmi Server is running...");
		}
		catch( Exception e){
			System.out.println("Rmi server exceptinon...");
		}
	}
}
