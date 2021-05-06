package tasks;

import java.util.ArrayList;

import interfaces.IFlashDiscountTask;
import model.FlashDiscount;

public class Tasks implements IFlashDiscountTask{

  private ArrayList<IFlashDiscountTask> tasks = new ArrayList<IFlashDiscountTask>();

  public boolean addTask(IFlashDiscountTask t){
    if(t == null){
      return false;
    }
    return tasks.add(t);
  }

  @Override
  public void execute(FlashDiscount fd) {
    tasks.forEach((t) -> t.execute(fd));
  }
  
}
