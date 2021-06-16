package mx.com.gm.pelicula.servicio;

import mx.com.gm.pelicula.datos.AccesoDatos;
import mx.com.gm.pelicula.datos.AccesoDatosImpl;
import mx.com.gm.pelicula.domain.Pelicula;
import mx.com.gm.pelicula.excepciones.AccesoDatosEx;

public class CatalogoPeliculasImpl implements CatalogoPeliculas{

    //Atributos
    private final AccesoDatos datos;

    //Constructor

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try{
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula,NOMBRE_RECURSO,anexar);
        }catch (AccesoDatosEx ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void listarPelicula() {
        try{
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (var pelicula: peliculas) {
                System.out.println("pelicula: " + pelicula);
            }
        }catch (AccesoDatosEx ex){
            System.out.println("Error Acceso a Datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        }catch (AccesoDatosEx ex){
            System.out.println("Error al buscar pelicula");
            ex.printStackTrace(System.out);
        }
        System.out.println("Resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        }catch (AccesoDatosEx ex){
            System.out.println("Error al iniciar catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
    }
}
