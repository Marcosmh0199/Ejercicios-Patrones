package model;

public class User {
  private static int id = 1;
  private String nombre;
  private int userId;

  public User(String nombre){
    setUserId(id);
    setNombre(nombre);
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

  

}
