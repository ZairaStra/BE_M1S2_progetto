package zairastra.entities;

import zairastra.entities.exceptions.InputError;

public class Tablegame extends Game {

    //ATTRIBUTI
    private int playerNumb;
    private int duration;


    //COSTRUTTORI
    //RICORDA SEMPRE: devi passare l'exception checked nella classe per poi gestirla col try-catch nell'Application
    public Tablegame(String id, String title, int year, double price, int playerNumb, int duration) throws InputError {
        super(id, title, year, price);
        //elimino l'enum per i giocatori e faccio un if per controllare che il valore sia corretto passando l'exception InputError
        if (playerNumb < 2 || playerNumb > 10)
            throw new InputError("Numero giocatori non valido");
        this.playerNumb = playerNumb;
        this.duration = duration;
    }

    //METODI


    public int getPlayerNumb() {
        return playerNumb;
    }

    //RICORDA SEMPRE: devi passare l'exception checked nella classe per poi gestirla col try-catch nell'Application
    public void setPlayerNumb(int playerNumb) throws InputError {
        //faccio lo stesso controllo anche nel setter per l'eventuale modifica
        if (playerNumb < 2 || playerNumb > 10)
            throw new InputError("Numero giocatori non valido");
        this.playerNumb = playerNumb;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
