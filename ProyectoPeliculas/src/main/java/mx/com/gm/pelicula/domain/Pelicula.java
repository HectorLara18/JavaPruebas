package mx.com.gm.pelicula.domain;

public class Pelicula {
    //Atributos
    private String nombre;
    private int year;
    private int duration;

    //Constructor
    public Pelicula(){}

    public Pelicula(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
