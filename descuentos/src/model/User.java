package model;

public class User {
  private static int id = 1;
  private int userId;
  private String nombre;
  private String email;

  private Inbox inbox;
  
  public User(String nombre, String email){
    setUserId(id);
    setNombre(nombre);
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

  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
}
