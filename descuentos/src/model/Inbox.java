package model;

import java.util.ArrayList;

public class Inbox {
  private ArrayList<Message> messages;
  @SuppressWarnings("unused")
  private String email;

  public Inbox(String email) {
    setEmail(email);
    setMessages();
  };

  public void setEmail(String email) {
    this.email = email;
  }

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
