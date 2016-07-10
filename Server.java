package org.neu.jpcap.kengdie;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
	private ServerSocket ss;
	public Server(int port) throws IOException{
		ss = new ServerSocket(port);
		ss.setSoTimeout(10000);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Socket server =  ss.accept();
				DataInputStream din = new DataInputStream(server.getInputStream());
				byte buffer[] = new byte[1024];
				int len = din.read(buffer);
				String getString = new String(buffer,0,len);
				System.out.println("you have received a file request!");
				DataOutputStream dout = new DataOutputStream(server.getOutputStream());
				FileInputStream fis = new FileInputStream(new File("E:\\"+getString));
				byte b[] = new byte[1024];
				fis.read(b);
				dout.write(b);
				dout.close();
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
//				System.out.println("Ω” ‹≥¨ ±");
			}
		}
	}
	
}
