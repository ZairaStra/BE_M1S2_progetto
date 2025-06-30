package zairastra.entities;

import zairastra.entities.exceptions.IdDuplicated;
import zairastra.entities.exceptions.IdNotFound;
import zairastra.entities.exceptions.InputError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//uso una Map con id univoco come chiave e nome del gioco come valore
public class Collection {
    //ATTRIBUTI
    private Map<String, Game> games;

    //COSTRUTTORI
    public Collection() {
        this.games = new HashMap<>();
    }

    //METODI

    //aggiunta elementi con controllo su id-chiave
    public void addGame(Game game) throws IdDuplicated {
        if (games.get(game.getId()) != null) {
            throw new IdDuplicated("Codice identificativo già in uso");
        }
        games.put(game.getId(), game);
    }

    //cerca per prezzo< all'inserito (ricorda che il prezzo dev'essere positivo)
    //RICORDA:in questo caso devi cercare sia per giochi da tavolo che per videogiochi
    public List<Game> searchByPrice(double price) throws InputError {
        if (price <= 0) {
            throw new InputError("Prezzo non valido");
        }
        return games.values().stream()
                .filter(game -> game.getPrice() < price)
                .toList();
    }

//    //cerca per numero giocatori - quindi solo giochi da tavolo
//    public List<Tablegame> searchByPlayerNumb(int players) {
//        if (players < 2 || players > 10) {
//            throw new InputError("Numero giocatori non valido");
//        }

    /// /        return games.values().stream()
    /// /                .filter(game -> game.getPlayerNumb)
    /// /                .toList();
//        //da errore - dice che Game non ha playerNumb, infatti sta in Tablegame - quindi devo arrivare a Tablegame che estende Game?
//    }

    //rimuovi per id-chiave
    public void removeById(String id) throws IdNotFound {
        if (games.get(id) == null) {
            throw new IdNotFound("Codice identificativo non trovato");
        }
        games.remove(id);
    }

    //accedi a tutti i dati per id e modifica
    
    //stampa statistiche in console: num totale in map, prezzo maggiore, media prezzi

}
