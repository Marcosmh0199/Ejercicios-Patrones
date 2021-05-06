package Model;

import java.util.Random;

public class Matrix {
  private int[] m;
  private int width;
  private int height;
  private final int MAX = 2;

  public Matrix(int width, int height, Random rand){
    this.width = width;
    this.height = height;
    setM();
    fillM(rand);
  }

  private void setM(){
    m = new int[width * height];
  }

  public int[] getM(){
    return m;
  }

  public int getWidth(){
    return width;
  }

  public int getHeight(){
    return height;
  }

  private void fillM(Random rand){
    for(int j = 0; j < height; j++){
      for(int i = 0; i < width; i++){
        m[i*j] = rand.nextInt(MAX);
      }
    }
  }

  public int getValue(int width, int height){
    return m[width * height];
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
