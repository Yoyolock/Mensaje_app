package Mensaje_app;

import java.util.Scanner;

public class mensajeService {

    public static void crearMensaje(){
        Scanner reader = new Scanner(System.in);

        System.out.println("Escribe tu mensaje");
        String mensaje = reader.nextLine();

        System.out.println("¿Cual es tu nombre?");
        String nombre = reader.nextLine();

        mensajes registro = new mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);

        MensajesDAO.crearMensajeDB(registro);
    }

    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }

    public static void editarMensaje(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje");
        String mensaje = reader.nextLine();

        System.out.println("Indica la ID del mensaje a modificar");
        int id_mensaje = reader.nextInt();
        mensajes actualizacion = new mensajes();
        actualizacion.setId_mensaje(id_mensaje);
        actualizacion.setMensaje(mensaje);
        MensajesDAO.actualizarMensajeDB(actualizacion);
    }
    public static void eliminarMensaje(){
        Scanner reader = new Scanner(System.in);
        System.out.println("indica la ID del mensaje a borrar");
        int id_mensaje = reader.nextInt();
        MensajesDAO.borrarMensajeDB(id_mensaje);

    }
}
