public class Match {
  private Integer attempts;
  private String word;
  private Boolean partyWins;

  public Match(String word){
    // TODO: Mauricio
    this.attempts = 6;
    this.partyWins = false;
    this.word = word;
  }

  public Boolean isTheMatchOver(){
    // TODO: Mauricio
    if(this.attempts > 0) return true;
    return false;
  }

  public Integer getAttempts(){
    return this.attempts;
  }

  public String checkPlay(String word){
    // TODO: Marcus
    return "";
  }
}
