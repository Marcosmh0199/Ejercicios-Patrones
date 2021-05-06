package controller;

import java.util.ArrayList;

import model.FlashDiscount;
import model.User;

public class Controller {
  public static ArrayList<User> users;
  public static ArrayList<FlashDiscount> flashDiscounts;

  public Controller(){
    setUsers();
    setFlashDiscounts();
  }

  public ArrayList<User> getUsers() {
    return users;
  }
  private void setUsers() {
    users = new ArrayList<User>();
  }

  public ArrayList<FlashDiscount> getFlashDiscounts() {
    return flashDiscounts;
  }
  private void setFlashDiscounts() {
    flashDiscounts = new ArrayList<FlashDiscount>();
  }

  public void addFlashDiscounts(FlashDiscount fd){
    flashDiscounts.add(fd);
  }

  public void addUser(User u){
    users.add(u);
  }
}
