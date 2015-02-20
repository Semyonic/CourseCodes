import java.rmi.Remote;
import java.rmi.RemoteException;

import org.omg.CORBA.portable.RemarshalException;


public interface RmiInterface extends Remote {

	public String merhaba()throws RemoteException;
}
