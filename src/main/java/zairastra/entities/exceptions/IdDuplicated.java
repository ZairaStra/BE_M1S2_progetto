package zairastra.entities.exceptions;

//RICORDATI SEMPRE - di default crea una Runtime Exception che però è unchecked e non consente la gestione dell'errore nell'Application
//trasformale in Exception e usa trycatch
public class IdDuplicated extends Exception {
    public IdDuplicated(String message) {
        super(message);
    }
}
