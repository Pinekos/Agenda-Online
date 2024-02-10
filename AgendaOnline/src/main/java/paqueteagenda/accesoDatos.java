package paqueteagenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class accesoDatos {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/alumnos?user=root";

    public static void insertarContacto(Contacto c) {
        String sql = "INSERT INTO registro(nombre, apellido, telefono) VALUES (?, ?, ?)";
        
        try {
        	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(DB_URL);
	        	PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	            
	            pstmt.setString(1, c.getName());
	            pstmt.setString(2, c.getSurname());
	            pstmt.setString(3, c.getPhone());
	            pstmt.execute();
	            
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void borrarContacto(String telefono) {
        String sql = "DELETE FROM registro WHERE telefono = ?";
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(DB_URL);
		             PreparedStatement pstmt = conn.prepareStatement(sql)) {
		            
		            pstmt.setString(1, telefono);
		            
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    public static List<Contacto> buscarContactosPorNombre(String nombre) {
        List<Contacto> contacts = new ArrayList<>();
        String sql = "SELECT nombre, apellido, telefono FROM registro WHERE nombre LIKE ?";
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(DB_URL);
		             PreparedStatement pstmt = conn.prepareStatement(sql)) {
		            
		            pstmt.setString(1, "%" + nombre + "%");
		            
		            try (ResultSet rs = pstmt.executeQuery()) {
		                while (rs.next()) {
		                    String name = rs.getString("nombre");
		                    String surname = rs.getString("apellido");
		                    String phone = rs.getString("telefono");
		                    contacts.add(new Contacto(name, surname, phone));
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return contacts;
    }

    public static List<Contacto> obtenerTodosLosContactos() {
        List<Contacto> contacts = new ArrayList<>();
        String sql = "SELECT nombre, apellido, telefono FROM registro";
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(DB_URL);
		             PreparedStatement pstmt = conn.prepareStatement(sql)) {
		            
		            try (ResultSet rs = pstmt.executeQuery()) {
		                while (rs.next()) {
		                    String name = rs.getString("nombre");
		                    String surname = rs.getString("apellido");
		                    String phone = rs.getString("telefono");
		                    contacts.add(new Contacto(name, surname, phone));
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }	        

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return contacts;
    }

}

