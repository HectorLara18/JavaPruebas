package mx.com.gm.pelicula.presentacion;

import mx.com.gm.pelicula.servicio.CatalogoPeliculas;
import mx.com.gm.pelicula.servicio.CatalogoPeliculasImpl;

import java.util.Scanner;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
 
        while(opcion != 0){
            System.out.println("Elige una opcion: \n" +
                    "1. Iniciar Catalogo peliculas \n" +
                    "2. Agregar pelicula \n" +
                    "3. Listar peliculas \n" +
                    "4. Buscar pelicula \n" +
                    "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce nombre pelicula: \n");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPelicula();
                    break;
                case 4:
                    System.out.println("Introduce una pelicula a buscar: ");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
                    break;
            }
        }
    }
}
