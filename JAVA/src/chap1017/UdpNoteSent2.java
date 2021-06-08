package chap1017;
import java.io.*;
import java.net.*;

public class UdpNoteSent2 {

	public static void main(String[] args) throws Exception {
		
		String ip = "192.168.0.132"; 
		String type = "notepad.exe"; // explorer.exe
		
	//키보드로 명령어 받기	
    BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
    
    while(true) {
    	type=keyboard.readLine();
		DatagramSocket dsocket = new DatagramSocket(); //파일을 전송할 소켓 객체를 생성 
		InetAddress ia = InetAddress.getByName(ip); //전송받을 곳의 IP주소를 InetAddress 객체로 생성
		
		DatagramPacket packet = new DatagramPacket(
				type.getBytes(), type.getBytes().length, ia, 7777);
		dsocket.send(packet);
		dsocket.close();
		System.out.println("명령전송 완료");
    }

	}

}