package Mensaje_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    public static void crearMensajeDB(mensajes mensajes){
        Conexion dbConnect = new Conexion();

        try (Connection conexion = dbConnect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensajes.getMensaje());
                ps.setString(2, mensajes.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("se creó el mensaje de pana");
            }catch (SQLException ex){
                System.out.println(ex);
            }

        }catch (SQLException e){
            System.out.println(e);

        }
    }
    public static void leerMensajesDB(){
        Conexion dbConnect = new Conexion();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conexion = dbConnect.get_connection()) {
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("ID: "+ rs.getInt("id_mensaje"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor_mensaje"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                System.out.println("");
            }

            }catch (SQLException e){
            System.out.println("no se pudieron recuperar las weas de mensajes");
            System.out.println(e);
        }
    }
    public static void borrarMensajeDB(int id_mensaje){
        Conexion dbConnect = new Conexion();

        try (Connection conexion = dbConnect.get_connection()) {
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("la wea de mensaje fue borrao");
            }catch (SQLException e){
                System.out.println(e);

            }

        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void actualizarMensajeDB(mensajes mensajes){
        Conexion dbConnect = new Conexion();

        try (Connection conexion = dbConnect.get_connection()) {
        PreparedStatement ps = null;
            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensajes.getMensaje());
                ps.setInt(2, mensajes.getId_mensaje());
                ps.executeUpdate();
                System.out.println("La wea se actualizó de pana");

            }catch (SQLException e){
                System.out.println(e);
                System.out.println("no se pudo actualizar la wea");

            }
        }catch (SQLException e){

        }
    }
}
