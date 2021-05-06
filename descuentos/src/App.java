import java.util.Scanner;

import controller.Controller;
import model.FlashDiscount;
import model.User;
import tasks.TaskManager;
import tasks.Tasks;

public class App {
  public static void main(String[] args) throws Exception {
    Controller c = new Controller();
    //Agregar usuarios default
    c.addUser(new User("Marcos Méndez", "mMendez@mail.com"));
    c.addUser(new User("Jaime Soto", "jSoto@mail.com"));
    c.addUser(new User("Carlos Araya", "cAraya@mail.com"));

    Tasks tasks = new Tasks();
    tasks.addTask(new tasks.SendFlashDiscount());
    TaskManager taskManager = new TaskManager();
    Scanner sc = new Scanner(System.in);
    int option = 0;
    while(option != 3){
      System.out.println("1. Agregar usuario");
      System.out.println("2. Realizar promoción");
      System.out.println("3. Salir del programa");
      option = sc.nextInt();
      sc.nextLine();
      switch(option){
        case 1:
        {
          System.out.print("Ingrese el nombre: "); String name = sc.nextLine(); System.out.println();
          System.out.print("Ingrese el correo: "); String email = sc.nextLine(); System.out.println();
          c.addUser(new User(name, email)); System.out.println("Usuario agregado.");
        }
        break;
        case 2:
        {
          System.out.print("Ingrese la duración en minutos: "); FlashDiscount fd = new FlashDiscount(sc.nextInt()); System.out.println();
          c.addFlashDiscounts(fd);
          taskManager.execute(tasks, fd); System.out.println("Descuento agregado.");
        }
        break;
        default:
        {
          option = 3;
          sc.close();
        }
        break;
      }
      System.out.println("-----------------------------------------------------------");
    }
  }
}
