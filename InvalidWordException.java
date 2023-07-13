public class InvalidWordException extends Exception {
    public InvalidWordException() {
        super("A palavra nao esta no dicionario.");
    }
}