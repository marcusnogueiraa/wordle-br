import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
  private Scanner sc;
  private ArrayList<String> words;

  public Dictionary(){
    // TODO: Mauricio
    words = new ArrayList<String>();
    try{
      sc = new Scanner(new File("br-uft8.txt"));
      
      while(sc.hasNextLine()){
        words.add(sc.nextLine());
      }
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado: " + e.getMessage());
    }
  }
  
  public String newRandomWord(){
    // TODO: Mauricio
    Random rnd = new Random();
		long seed = System.currentTimeMillis();
		rnd.setSeed(seed);
		return words.get(rnd.nextInt(words.size()));
  }

  public Boolean validateWord(String word){
    // TODO: Mauricio
    Integer begin = 0, end = words.size(), meio = (begin + end) / 2;
    
    while(end >= begin){
        if(word.equals(words.get(meio))) return true;
        if(word.compareToIgnoreCase(words.get(meio)) > 0) begin = meio + 1;
        else end = meio - 1;
    }

    return false;
  }

}