package mx.com.gm.pelicula.datos;

import java.util.*;
import mx.com.gm.pelicula.domain.Pelicula;
import mx.com.gm.pelicula.excepciones.AccesoDatosEx;
import mx.com.gm.pelicula.excepciones.EscrituraDatosEx;
import mx.com.gm.pelicula.excepciones.LecturaDatosEx;

public interface AccesoDatos {

    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

    void crear(String nombreRecurso) throws AccesoDatosEx;

    void borrar(String nombreRecurso) throws  AccesoDatosEx;

}


