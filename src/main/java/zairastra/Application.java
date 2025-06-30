package zairastra;

import zairastra.entities.Collection;
import zairastra.entities.Videogame;
import zairastra.entities.enums.Device;
import zairastra.entities.enums.Genre;
import zairastra.entities.exceptions.IdDuplicated;
import zairastra.entities.exceptions.InputError;

import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);
    private static Collection gameCollection = new Collection();

    public static void main(String[] args) {
        boolean isRunnung = true;

        while (isRunnung) {
            showMenu();
            String toDo = scanner.nextLine();

            switch (toDo) {
                case "1" -> addVideogame();
                case "2" -> addTablegame();
                case "3" -> searchByPrice();
                case "4" -> searchByPlayerNumber();
                case "5" -> removeById();
                case "0" -> {
                    System.out.println("Esecuzione terminata");
                    isRunnung = false;
                }
                default -> System.out.println("Input non valido");
            }

        }
    }

    private static void showMenu() {
        System.out.println("Digita il numero che corrisponde all'azione che vuoi compiere:");
        System.out.println("1 - Aggiungi videogame");
        System.out.println("2 - Aggiungi gioco da tavolo");
        System.out.println("3 - Ricerca per prezzo massimo");
        System.out.println("4 - Ricerca per numero di giocatori");
        System.out.println("5 - Ricerca per codice identificativo");
        System.out.println("0 - Termina esecuzione");
    }

    //RICORDATI DI GESTIRE LE EXCEPTION
    private static void addVideogame() {
        try {
            System.out.println("Id: ");
            String id = scanner.nextLine();

            System.out.println("Nome: ");
            String title = scanner.nextLine();

            System.out.println("Anno pubblicazione: ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.println("Prezzo: ");
            double price = Double.parseDouble(scanner.nextLine());

            //scelta tra i dispositivi: va gestito l'errore
            //metto un while interno con try catch e dentro lo swicth per i diversi acsi
            Device device = null;
            while (device == null) {
                try {

                    System.out.println("Tipo di dispositivo: 1.PC, 2.PS5, 3.XBOX, 4.SWITCH, 5.WII");
                    int chooseDevice = Integer.parseInt(scanner.nextLine());
                    device = switch (chooseDevice) {
                        case 1 -> Device.PC;
                        case 2 -> Device.PS5;
                        case 3 -> Device.XBOX;
                        case 4 -> Device.SWITCH;
                        case 5 -> Device.WII;
                        default -> throw new InputError("Input non valido");
                    };
                } catch (InputError error) {
                    System.out.println(error.getMessage());
                }
            }
            System.out.println("Durata di gioco media: ");
            int duration = Integer.parseInt(scanner.nextLine());

            //scelta tra i generi: va gestito l'errore
            //metto un while interno con try catch e dentro lo swicth per i diversi acsi
            Genre genre = null;
            while (genre == null) {
                try {
                    System.out.println("Genere: 1. FANTASY, 2. MILITARE, 3. SIMULAZIONE, 4. STORICO");
                    int chooseGenre = Integer.parseInt(scanner.nextLine());
                    genre = switch (chooseGenre) {
                        case 1 -> Genre.FANTASY;
                        case 2 -> Genre.MILITARE;
                        case 3 -> Genre.SIMULAZIONE;
                        case 4 -> Genre.STORICO;
                        default -> throw new InputError("Input non valido");
                    };
                } catch (InputError e) {
                    System.out.println(e.getMessage());
                }
            }
            Videogame videogame = new Videogame(id, title, year, price, device, duration, genre);
            gameCollection.addGame(videogame);
            System.out.println("Videogame aggiunto alla lista");

        } catch (IdDuplicated e) {
            System.out.println("Errore: ID duplicato! " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Errore generico: " + e.getMessage());
        }
    }
}


