import java.util.Set;
import java.util.HashSet;

public class Match {
  private Integer attempts;
  private String word;
  private Boolean wasWon;

  public Match(String word){
    this.attempts = 6;
    this.wasWon = null;
    this.word = word;
  }

  private Character verifyLetter(char letter, Integer position, Set<Character> verifiedLetters){
    if (this.word.contains(String.valueOf(letter))){
      for (Integer i = 0; i < 5; i++){
        if (this.word.charAt(i) == letter && position == i) return '+';
      }

      if (!verifiedLetters.contains(letter)){
        return '-';
      } else {
        return '*';
      }
    }

    return '*';
  }

  public String getWord(){
    return this.word;
  }

  public Boolean wasWon(){
    return this.wasWon;
  }

  public Integer getAttempts(){
    return this.attempts;
  }

  public String checkPlay(String word){
    Set<Character> verifiedLetters = new HashSet<Character>();
    String result = "";
    for (int i = 0; i < 5; i++){
      result += verifyLetter(word.charAt(i), i, verifiedLetters) + " ";
      verifiedLetters.add(word.charAt(i));
    }

    this.attempts--;
    if (result.equals("+ + + + + ")) this.wasWon = true;
    else if (this.attempts == 0) this.wasWon = false;

    return result;
  }
}