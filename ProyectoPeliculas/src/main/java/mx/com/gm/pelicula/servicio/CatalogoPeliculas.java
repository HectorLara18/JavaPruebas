package mx.com.gm.pelicula.servicio;

public interface CatalogoPeliculas {

    String NOMBRE_RECURSO = "peliculas.txt";

    void agregarPelicula(String nombrePelicula);

    void listarPelicula();

    void buscarPelicula(String nombrePelicula);

    void iniciarCatalogoPeliculas();
}
