package model;

public class User {
  private static int id = 1;
  private int userId;
  private String name;
  private String email;

  private Inbox inbox;
  
  public User(String name, String email){
    setUserId(id);
    setName(name);
    setEmail(email);
    setInbox();
  }

  public Inbox getInbox() {
    return inbox;
  }
  private void setInbox() {
    inbox = new Inbox(email);
  }

  public int getUserId() {
    return userId;
  }
  public void setUserId(int userId) {
    this.userId = userId;
    id++;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String toString(){
    return name;
  }
}
