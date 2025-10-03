package cl.web.DAO;

import java.util.List;

import cl.web.DTO.Producto;

public interface ProductoDAO {
	void crear(Producto producto);
    List<Producto> obtenerTodos();
    void eliminar(int id);
}
