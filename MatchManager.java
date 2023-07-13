public class MatchManager{
  private Match currentMatch;
  private Dictionary dictionary;

  public MatchManager(){
    this.dictionary = new Dictionary();
    this.currentMatch = null;
  }

  public Boolean theMatchWasWon(){
    if (this.currentMatch == null) return null;
    return currentMatch.wasWon();
  }

  public String getMatchWord(){
    return this.currentMatch.getWord();
  }

  public void startGame() {
    String word = this.dictionary.newRandomWord();
    this.currentMatch = new Match(word);
  }

  public String play(String word) throws InvalidWordException {
    word = word.toLowerCase();
    if (!dictionary.validateWord(word)) throw new InvalidWordException();
    if (this.theMatchWasWon() != null) throw new HasNotAMatchInProgressException();

    String result = this.currentMatch.checkPlay(word);

    return result;
  }

}