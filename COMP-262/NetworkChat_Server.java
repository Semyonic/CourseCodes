import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Server extends JFrame implements Runnable, ActionListener,MouseListener,KeyListener  {
	
	private JButton btnServer;
	private JLabel lblPort,lblStat;
	private JTextField txtField;
	private JTextArea txtArea;
	
	public Server() {
		// TODO Auto-generated constructor stub
		
		btnServer = new JButton("Start");
		btnServer.addActionListener(this);
		btnServer.setSize(80, 50);
		btnServer.setLocation(200, 5);

		txtField = new JTextField();
		txtField.setSize(80, 80);
		txtField.setLocation(50, 50);
		
		txtArea = new  JTextArea();
		txtArea.setSize(10, 10);
		txtArea.setLocation(150, 90);
		
		lblPort = new JLabel();
		lblPort.setSize(70, 50);
		lblPort.setLocation(10, 5);
		
		
		add(btnServer);
		add(txtField);
		add(txtArea);
		
				
		setTitle("Server");
		setSize(300, 300);
		setVisible(true);
	}
	
	public void run(){
		
		while(true){
			
			try{
				
			       ServerSocket server = new ServerSocket(1027);
			       lblStat.setText("Waiting client...");
			       Socket socket = server.accept();
			       
			       System.out.println("Socket address: "+socket.getRemoteSocketAddress());
			       System.out.println("Socket address port: "+socket.getPort());
			       System.out.println("Socket local port: "+socket.getLocalPort());
			       System.out.println("address: "+socket.getInetAddress());
			       
			       System.out.println("Server: I have a client");
			       
			       DataInputStream data = new DataInputStream(socket.getInputStream());
			       String kk = data.readUTF();
			       
			       DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
			       
			       dataOut.flush();
			       dataOut.close();
			       data.close();
			       socket.close();
			       server.close();
			
			}
			
			catch(IOException e){
				
				lblStat.setText("An error occured !");
				System.out.println("An error occured !");
				break;
			}	
			
		}
		
	}

	public static void main(String[] args) {
		
		new Server();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		Thread t=new Thread(this);
		t.start();
		lblStat.setText("Server is running");
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
