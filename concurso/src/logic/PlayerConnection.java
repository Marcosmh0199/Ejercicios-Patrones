package logic;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class PlayerConnection extends Thread{
  private Socket socket;
  private InputStream inputStream;
  private BufferedReader clientIn;
  private DataOutputStream out;

  public PlayerConnection(Socket socket){
    this.socket = socket;
    connect(socket);
  }

  private void connect(){
    try {
      inputStream = socket.getInputStream();
      clientIn = new BufferedReader(new InputStreamReader(inputStream));
      out = new DataOutputStream(socket.getOutputStream());
    } catch (IOException e) {
      return;
    }
  }

  public void closeConnection(){
    try {
      clientIn.skip(0);
      clientIn.close();
      inputStream.close();
      out.close();
      socket.close();
    } catch (Exception e) {
      return;
    }
  }

  @Override
  public void run(){
    super.run();
    try {
      boolean won = false;
      catchNick();
      waitRoom();
      out.write(("Servidor: " + Server.game.getAnswer().hint+"\n").getBytes("UTF-8"));
      out.flush();
      String clientMessage = "";
      while(!won){
        clientMessage = clientIn.readLine();
        won = Server.game.checkAnswer(clientMessage);
        if(won){
          out.write(("Servidor: Ha ganado!\n").getBytes("UTF-8"));
          Server.endGame();
        }else{
          out.write(("Servidor: Ha fallado, vuelva a intentarlo.\n").getBytes("UTF-8"));
        }
      }
    } catch (Exception e) {
      return;
    }
  }

  private void catchNick(){
    String nick = null;
    try {
      nick = clientIn.readLine();
      while(Server.playersConnections.containsKey(nick)){
        out.write(("Servidor: El nick ya está en uso, pruebe con otro.\n").getBytes("UTF-8"));
        out.flush();
        nick = clientIn.readLine();
      }
      Server.playersConnections.put(nick, this);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void waitRoom(){
    try{
      while(Server.playersConnections.size() < Server.MIN_PLAYERS){
        out.write(("Servidor: Esperando más jugadores... Presione 'Enter' para reintentar. \n").getBytes("UTF-8"));
        out.flush();
        clientIn.readLine().getBytes("UTF-8");
      }
    }catch (Exception e) {
      return;
    }
  }
}
