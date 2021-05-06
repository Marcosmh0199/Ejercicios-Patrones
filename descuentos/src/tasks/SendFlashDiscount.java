package tasks;

import controller.Controller;
import interfaces.IFlashDiscountTask;
import model.FlashDiscount;
import model.Message;
import model.User;

public class SendFlashDiscount implements IFlashDiscountTask{

  @Override
  public void execute(FlashDiscount fd) {
    for(User u : Controller.users){
      Message m = new Message(
        "Hay un nuevo descuento", 
        "descuentosCmp@userInfo.com", 
        u.getEmail(), 
        "Hola " + u.getNombre() + ", le informamos que contamos con un nuevo descuento a partir de " + fd.getBegDate() +" hasta "+ fd.getEndDate() + ".\n" + 
        "Por favor no responder a este mensaje.");
      u.getInbox().receiveMessage(m);
      System.out.println("Descuento Flash envíado al usuario "+ u +"!");
    }
  }
}
