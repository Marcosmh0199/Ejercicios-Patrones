package logic;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;


public class Client{
  private String serverIP;
  private int port;
  private InputStream inputStream = null;
  private BufferedReader serverIn = null;
  private DataOutputStream serverOut = null;

  public Client(String serverIP, int port){
    this.serverIP = serverIP;
    this.port = port;
  }

  public void run() {
    try {
      Socket serverSocket = new Socket(this.serverIP, this.port);
      inputStream = serverSocket.getInputStream();
      serverIn = new BufferedReader(new InputStreamReader(inputStream));
      serverOut = new DataOutputStream(serverSocket.getOutputStream());
      Scanner sc = new Scanner(System.in, "UTF-8");
      System.out.print("Ingrese su nick: ");
      serverOut.writeBytes((sc.nextLine()+"\n"));
      System.out.println("");
      String serverMessage;
      while(true){
        serverMessage = serverIn.readLine();
        if(serverMessage == null){
          System.out.println("Otro jugador ha ganado.");
          break;
        }else if(serverMessage.contains("ganado")){
          System.out.println(serverMessage);
          break;
        }
        System.out.println(serverMessage);
        serverOut.writeBytes(sc.nextLine()+"\n");
      }
      if(!serverSocket.isClosed()){
        serverSocket.close();
      }
      sc.close();
    }catch (Exception e) { //Conexión cerrada de forma abrupta
      System.out.println("Otro jugador ha ganado.");
    }
  }

  public static void main(String[] args){
    Client client = new Client("localhost", 8888);
    client.run();
  }
}
