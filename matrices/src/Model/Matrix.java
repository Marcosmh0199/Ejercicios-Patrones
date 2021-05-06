package Model;

import java.util.Random;

public class Matrix {
  private int[] m;
  private int width;
  private int height;
  private final int MAX = 2;

  public Matrix(int width, int height){
    this.width = width;
    this.height = height;
    setM();
    fillM();
  }

  private void setM(){
    m = new int[width * height];
  }

  private void fillM(){
    Random rand  = new Random();
    for(int j = 0; j < height; j++){
      for(int i = 0; i < width; i++){
        m[i*j] = rand.nextInt(MAX);
      }
    }
  }

  public int[] getM(){
    return m;
  }

  public String toString(){
    String mStr = "";
    for(int j = 0; j < height; j++){
      for(int i = 0; i < width; i++){
        mStr += Integer.toString(m[i*j]) + "\t";
      }
      mStr += "\n";
    }
    return mStr;
  }
}
