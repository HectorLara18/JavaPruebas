package mx.com.gm.pelicula.datos;

import mx.com.gm.pelicula.domain.Pelicula;
import mx.com.gm.pelicula.excepciones.AccesoDatosEx;
import mx.com.gm.pelicula.excepciones.EscrituraDatosEx;
import mx.com.gm.pelicula.excepciones.LecturaDatosEx;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements AccesoDatos{

    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while(linea != null){
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
        } catch(FileNotFoundException ex){
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar pelicula");
        } catch (IOException ex){
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar pelicula");
        } return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se a escrito information en el archivo");
        }catch (IOException ex){
            System.out.println(ex.getMessage());
            throw new EscrituraDatosEx("Excepcion al escribir peliculas");
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            var indice = 1;
            while(linea != null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Pelicula " + linea + " Encontrada en el incide " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar");
        }catch (IOException ex){
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al leer la linea");
        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try{
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("se a creado el archivo");
        }catch (IOException ex){
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear el archivo");
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        if(archivo.exists()){
            archivo.delete();
        }
        System.out.println("Se a borrado el archivo");
    }
}
