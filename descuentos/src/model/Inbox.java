package model;

import java.util.ArrayList;

public class Inbox {
  private ArrayList<Message> messages;

  public Inbox() { 
    setMessages();
  };

  public ArrayList<Message> getMessageByTittle(){
    return null;
  }
  private void setMessages(){
    messages = new ArrayList<Message>();
  }

  public void receiveMessage(Message m){
    messages.add(m);
  }
  
}
