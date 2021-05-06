package logic;
import Model.Matrix;

public class MatrixAnalyzer {
  private static MatrixAnalyzer instance;

  private MatrixAnalyzer(){ }

  public static MatrixAnalyzer getInstance() {
    if (instance == null) {
        instance = new MatrixAnalyzer();
    }
    return instance;
  }

  public boolean isIdentity(Matrix m){
    int height  = m.getHeight();
    int width   = m.getWidth();
    if(height != width){
      return false;
    }
    for(int j = 0; j < height; j++){
      for(int i = 0; i < width; i++){
        if(j == i && m.getValue(i, j) == 0){
          return false;
        }else{
          if(m.getValue(i, j) == 1){
            return false;
          }
        }
      }
    }
    return true;
  }
}
