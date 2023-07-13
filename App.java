import java.util.Scanner;

class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MatchManager letexto = new MatchManager();

    System.out.println("=====================");
    System.out.println("BEM-VINDO AO LETREXTO");
    System.out.println("=====================\n");
    System.out.println("Instrucoes:");
    System.out.println("- O computador escolhera uma palavra aleatoria de cinco letras.");
    System.out.println("- Voce tem seis tentativas para adivinhar a palavra.");
    System.out.println("- A cada palpite, voce recebera feedback sobre o seu palpite:");
    System.out.println("      - Um \"+\" indica uma letra correta na posicao correta.");
    System.out.println("      - Um \"-\" indica uma letra correta na posicao errada.");
    System.out.println("      - Um \"*\" indica uma letra errada na posicao errada.\n");
    System.out.println("Vamos comecar!\n");
    
    while (true){
      
      System.out.print("\n[S] Iniciar Partida? ");
      String option = sc.nextLine();

      if (!option.equals("S")) break;

      Integer attemptCounter = 1;
      letexto.startGame();

      while(letexto.theMatchWasWon() == null){
        System.out.print("\nDigite palpite #" + attemptCounter + ": ");
        String word = sc.nextLine();
        System.out.print("\nPalpite:   ");
        for (Integer i = 0; i < word.length(); i++) System.out.print(word.charAt(i) + " ");
        System.out.println();

        String result;
        try{
          result = letexto.play(word);
        } catch(InvalidWordException err){
          continue;
        }

        System.out.print("Resultado: " + result);
        attemptCounter++;
      }


      if (letexto.theMatchWasWon()){
        System.out.printf("\nParabens! Voce adivinhou a palavra " + letexto.getMatchWord() 
        + " corretamente!\n");
      } else {
        System.out.printf("\nQue pena! VocÃª nao conseguiu adivinhar a palavra " 
        + letexto.getMatchWord() + " corretamente =(\n");
      }



    }

    sc.close();
  }
}