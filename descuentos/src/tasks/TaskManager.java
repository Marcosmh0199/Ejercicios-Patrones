package tasks;

import interfaces.IFlashDiscountTask;
import model.FlashDiscount;

public class TaskManager {
  public void execute(IFlashDiscountTask t, FlashDiscount fd){
    t.execute(fd);
  }
}
