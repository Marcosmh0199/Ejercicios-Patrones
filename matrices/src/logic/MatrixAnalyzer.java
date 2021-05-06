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
    return true;
  }
}
