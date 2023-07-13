import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary {
  private ArrayList<String> words;

  public Dictionary(){
    this.words = new ArrayList<String>();
    try (BufferedReader reader = new BufferedReader(new FileReader("br-utf8.txt"))){
      String line;
      while((line = reader.readLine()) != null){
        words.add(line);
      }
    } catch (IOException e) {
      System.out.println("Arquivo não encontrado: " + e.getMessage());
    }

  }

  public String newRandomWord(){
    Random rnd = new Random();
    long seed = System.currentTimeMillis();
    rnd.setSeed(seed);
    return words.get(rnd.nextInt(words.size()));
  }

  public Boolean validateWord(String word) {
      return this.words.contains(word);
  }


}