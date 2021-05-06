import java.util.Random;
import java.util.Scanner;

import Model.Matrix;
import logic.MatrixAnalyzer;

public class App {
  public static void main(String[] args) throws Exception {
    int width;
    int height;
    Scanner sc = new Scanner(System.in);
    MatrixAnalyzer mAnalyzer = MatrixAnalyzer.getInstance();
    Random rand = new Random();
    while(true){
      System.out.println("1. Ejecutar programa");
      System.out.println("2. Salir del programa");
      boolean option = (sc.nextInt() == 1);
      if(option){
        System.out.print("Ingrese el ancho de la matriz: ");
        width = sc.nextInt();
        System.out.println();
        System.out.print("Ingrese el alto de la matriz: ");
        height = sc.nextInt();
        System.out.println();
        Matrix m = new Matrix(width, height, rand);
        System.out.println(m);
        System.out.println( mAnalyzer.isIdentity(m) ? "La matriz es identidad" : "La matriz no es identidad" );
      }else{
        sc.close();
        break;
      }
    }
  }
}
