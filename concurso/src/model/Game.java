package model;

import java.util.ArrayList;
import java.util.Random;

public class Game {

  public class Pair{
    public String element, hint;
    public Pair(String element, String hint){
      this.element = element;
      this.hint = hint;
    }
  }

  private ArrayList<Pair> words;
  private ArrayList<Pair> numbers;
  private Random rand;
  private Pair answer;

  public Game(){
    setWords();
    setNumbers();
    rand = new Random();
    setAnswer();
  }

  private void setWords(){
    words = new ArrayList<Pair>();
    words.add(new Pair("Manzana"  , "Palabra; Se dice que comiendo esta fruta una vez al día, se evita la visita al doctor."));
    words.add(new Pair("Acera"    , "Palabra; Donde transitan los peatones."));
    words.add(new Pair("Café"     , "Palabra; Bebida matutina para despetarse."));
    words.add(new Pair("Pinto"    , "Palabra; Tradicional platillo costarricense que consiste en arroz mezclado con frijoles."));
    words.add(new Pair("Teclado"  , "Palabra; Se usa para escribir en una computadora."));
  }

  private void setNumbers(){
    numbers = new ArrayList<Pair>();
    numbers.add(new Pair("22"   , "Numero; Par de patos."));
    numbers.add(new Pair("12"   , "Numero; Una docena."));
    numbers.add(new Pair("100"  , "Numero; Diez decenas."));
    numbers.add(new Pair("5"    , "Numero; Se representa con la letra V en su forma romana."));
    numbers.add(new Pair("7"    , "Numero; Popularmente asociado a la buena suerte."));
  }

  public void setAnswer(){
    if(rand.nextInt(101) < 50){
      answer = words.get(rand.nextInt(words.size()));
    }else{
      answer = numbers.get(rand.nextInt(numbers.size()));
    }
  }

  public boolean checkAnswer(String answer){
    return answer.toLowerCase().equals(this.answer.element.toLowerCase());
  }
}
