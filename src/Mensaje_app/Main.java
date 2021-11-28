package Mensaje_app;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        int opcion = 0;
        //Se crea menú en el cual el usuario podrá elegir una opcion
        do {
            System.out.println();
            System.out.println("Aplicación de mensajes \n"
                                +"1. crear mensaje \n"
                                +"2. listar mensaje \n"
                                +"3. editar mensaje \n"
                                +"4. eliminar mensaje \n"
                                +"5. salir"
                                +"\n>");
                                //Se lee la opción del usuario
                                opcion = reader.nextInt();

                                switch (opcion){
                                    case 1:
                                        mensajeService.crearMensaje();
                                        break;
                                    case 2:
                                        mensajeService.listarMensajes();
                                        break;
                                    case 3:
                                        mensajeService.editarMensaje();
                                        break;
                                    case 4:
                                        mensajeService.eliminarMensaje();
                                        break;
                                    default:
                                        break;
                                }
        }while (opcion != 5);
        Conexion conexion = new Conexion();

        try(Connection cnx = conexion.get_connection()){
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
