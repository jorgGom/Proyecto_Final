package proyecto_final.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.clases.Producto;

public class ProductoDao {

	private Connection conn;
	private PreparedStatement statement = null;

	public ProductoDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public List<Producto> readProductos(){
		List <Producto> product=new ArrayList<>();
		
		String query = "SELECT * fROM productos";
		try {
			statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()){
				Producto pro = new Producto(rs.getInt("idproductos"),rs.getInt("vendido"),
						rs.getInt("vendedor"),rs.getInt("comprador"),
						rs.getString("nombre"),rs.getString("descripcion"),
						rs.getString("precio"));
				product.add(pro);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error getProducts");
			e.printStackTrace();
		}
		
		return product;
		
	}
	
	public void deleteProducto(int idproductos){
		String query = "DELETE FROM productos WHERE (idproductos=?)";
		
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, idproductos);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error SQL");
			e.printStackTrace();
		}
	}
	
	public boolean insertProduct(int idproductos,String nombre, String descripcion,String precio, int vendido, int vendedor, int comprador){
		boolean result= false;
		String query = "INSERT INTO productos VALUES (?,?,?,?,?,?,?)";
		
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, 0);
			statement.setString(2, nombre);
			statement.setString(3, descripcion);
			statement.setString(4, precio);
			statement.setInt(5, vendido);
			statement.setInt(6, vendedor);
			statement.setInt(7, comprador);
			statement.executeUpdate();
			statement.close();
			result= true;
		} catch (SQLException e) {
			System.out.println("Error SQL");
			e.printStackTrace();
		}
		return result;
	}

	public void modProduct(int idproductos, int vendido, int comprador, String nombre, String descripcion,
			String precio){
		String query = "UPDATE productos SET vendido=?, comprador=?, nombre=? , descripcion?, precio=? WHERE idproducto=?";
		
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, vendido);
			statement.setInt(2, comprador);
			statement.setString(3, nombre);
			statement.setString(4, descripcion);
			statement.setString(5, precio);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error SQL");
			e.printStackTrace();
		}
	}
	
	public Producto getProduct (int idproductos){
		String query = "SELECT * FROM productos WHERE (idproductos=?)";
		Producto prod=null;
		try {
			statement = conn.prepareStatement(query);
			statement.setLong(1, idproductos);
			ResultSet rs=statement.executeQuery();
			if (rs.next()) {
				prod = new Producto(rs.getInt("idproductos"),rs.getInt("vendido"),
						rs.getInt("vendedor"),rs.getInt("comprador"),
						rs.getString("nombre"),rs.getString("descripcion"),
						rs.getString("precio"));
			}
		} catch (SQLException e){
			System.out.println("Error SQL");
			e.printStackTrace();
		}
		return prod;
	}
	
	public List<Producto> getProductComprar (int iduser){
		String query = "SELECT * FROM productos WHERE (vendedor not Like ?)";
		List <Producto> prod = new ArrayList<>(); 
		Producto producto=null;
		try {
			statement = conn.prepareStatement(query);
			statement.setLong(1, iduser);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				producto = new Producto(rs.getInt("idproductos"),rs.getInt("vendido"),
						rs.getInt("vendedor"),rs.getInt("comprador"),
						rs.getString("nombre"),rs.getString("descripcion"),
						rs.getString("precio"));
				prod.add(producto);
			}
			statement.close();
		} catch (SQLException e){
			System.out.println("Error SQL");
			e.printStackTrace();
		}
		return prod;
	}
	
	public List<Producto> getProductUser (int idUser){
		String query = "SELECT * FROM productos WHERE (vendedor=?)";
		List <Producto> prod=new ArrayList<>();
		Producto producto=null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, idUser);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				producto = new Producto(rs.getInt("idproductos"),rs.getInt("vendido"),
						rs.getInt("vendedor"),rs.getInt("comprador"),
						rs.getString("nombre"),rs.getString("descripcion"),
						rs.getString("precio"));
			prod.add(producto);
			}
			statement.close();
		} catch (SQLException e){
			System.out.println("Error SQL");
			e.printStackTrace();
		}
		return prod;
	}
}
