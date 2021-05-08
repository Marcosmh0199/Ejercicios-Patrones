package logic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashMap;

import model.Game;

public class Server{

  private ServerSocket serverSocket; 
  private static boolean resetServer = false;
  public static Game game = new Game();
  public static HashMap<String, PlayerConnection> playersConnections = new HashMap<String, PlayerConnection>();
  public static final int MIN_PLAYERS = 3;

  public Server(int port, int queueSize) throws IOException{
    serverSocket = new ServerSocket(port, queueSize);
  }
  
  public void run(){
    try {
      while(true){
        if(resetServer){
          playersConnections.clear();
          game.setAnswer();
          System.out.println("Se ha reiniciado el servidor.");
          resetServer = false;
        }
        Socket newClient = serverSocket.accept(); 
        System.out.println("Cliente conectado\t" + newClient.getLocalAddress());
        new PlayerConnection(newClient).start();
      }
    }catch (SocketTimeoutException s) {
      System.out.println("Tiempo de espera agotado");
    }catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void endGame() throws IOException {
    for(String player: playersConnections.keySet()){
      playersConnections.get(player).closeConnection();
    }
    resetServer = true;
  }

  public static void main(String[] args) {
    int PORT = 8888;
    int QUEUE = 5;
    try {
      System.out.println("Servidor iniciado.");
      Server s = new Server(PORT, QUEUE);
      s.run();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
  

