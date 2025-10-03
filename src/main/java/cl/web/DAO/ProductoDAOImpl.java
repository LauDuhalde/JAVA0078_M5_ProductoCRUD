package cl.web.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.web.DTO.Producto;
import cl.web.util.ConexionDB;

public class ProductoDAOImpl implements ProductoDAO{
	private Connection conn;

    public ProductoDAOImpl() {
        conn = ConexionDB.getInstancia().getConexion();
    }
    
	@Override
	public void crear(Producto producto) {
		try {
            String sql = "INSERT INTO producto (nombre, precio, descripcion) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getPrecio());
            ps.setString(3, producto.getDescripcion());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public List<Producto> obtenerTodos() {
		List<Producto> lista = new ArrayList<>();
        try {
            String sql = "SELECT id, nombre, precio, descripcion FROM producto";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Producto producto = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("precio"),
                    rs.getString("descripcion")
                );
                lista.add(producto);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
	}

	@Override
	public void eliminar(int id) {
		try {
            String sql = "DELETE FROM producto WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
