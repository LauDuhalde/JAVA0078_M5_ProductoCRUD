package cl.web.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
	private static ConexionDB instancia;
    private Connection conexion;
    private final String driverDB = "postgresql";
    private final String hostDB = "localhost";
    private final String puertoDB = "5432";
    private final String nombreDB = "java0078";
    private final String URL = "jdbc:"+driverDB+"://"+hostDB+":"+puertoDB+"/"+nombreDB;
    
    //private final String URL = "jdbc:mysql://localhost:3306/gestion_usuarios";
    
    private final String USUARIO = "postgres";
    private final String CONTRASENA = "1234";
    //private final String USUARIO = "root";
    //private final String CONTRASENA = "Admin1234.";

    private ConexionDB() {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
        	Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConexionDB getInstancia() {
        if (instancia == null) {
            instancia = new ConexionDB();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
}
