import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Client {

	public static void main(String[] args) {
		// a simple client
		
		try{
			
			Socket socket= new Socket("127.0.0.1", 1027);
			DataOutputStream dataOut= new DataOutputStream(socket.getOutputStream());
			dataOut.writeUTF("Greetings from Dolapdere");
			dataOut.flush();
			
			DataInputStream dataInput= new DataInputStream(socket.getInputStream());
			System.out.println(dataInput.readUTF());
			
			
			dataInput.close();
			dataOut.close();
			socket.close();
			
		}
		catch(IOException e){
			System.out.println("Client have problem....");
		}
		
	}
}
