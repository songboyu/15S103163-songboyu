package org.neu.jpcap.kengdie;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
	public static void main(String[] args) throws UnknownHostException, IOException{
		Socket socket = new Socket("127.0.0.1", 8889);
		DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
		String key = "b.txt";
		dout.write(key.getBytes());
//		dout.close();
		
		InputStream input = socket.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(input));
		String getString;
		getString=reader.readLine();
		input.close();
		System.out.println(getString);
		socket.close();
	    
		
		socket  = new Socket(getString, 9000);
	    OutputStream outstream = socket.getOutputStream();
		outstream.write(key.getBytes());
		input = socket.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File("F:\\"+key));
		int tmp = 0;
		while((tmp=input.read())!=-1){
			fos.write(tmp);
		}
		fos.close();
		outstream.close();
		socket.close();
		
	}
}
