package zairastra.entities;

import zairastra.entities.enums.Device;
import zairastra.entities.enums.Genre;

public class Videogame extends Game {
    //ATTRIBUTI
    private Device device;
    private int duration;
    private Genre genre;


    //COSTRUTTORI

    public Videogame(String id, String title, int year, double price, Device device, int duration, Genre genre) {
        super(id, title, year, price);
        this.device = device;
        this.duration = duration;
        this.genre = genre;
    }


    //METODI


    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", device=" + device +
                ", duration=" + duration +
                ", genre=" + genre;
    }
}
