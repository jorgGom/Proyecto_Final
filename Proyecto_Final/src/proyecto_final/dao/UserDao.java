package proyecto_final.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.clases.Usuario;

public class UserDao {

	private Connection conn;
	private PreparedStatement statement = null;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public Usuario validateUser(String nombre, String password){
		Usuario u = null;
		String query = "SELECT * FROM usuarios WHERE nombre=? AND password=?";
		try {
			statement = conn.prepareStatement(query);
			statement.setString(1, nombre);
			statement.setString(2, nombre);
			statement.setString(3, password);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {				
				u = new Usuario(rs.getInt("id"),rs.getString("nombre"),
						rs.getString("apellido"),rs.getString("email"),
						rs.getString("password"));
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error: Validate User");
			e.printStackTrace();
		}
		return u;
	}
	
	public List<Usuario> readUsers(){
		List <Usuario> users=new ArrayList<>();
		
		String query = "SELECT * fROM usuarios";
		try {
			statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()){
				Usuario user = new Usuario(rs.getInt("id"),rs.getString("nombre"),
						rs.getString("apellido"),rs.getString("email"),
						rs.getString("password"));
				users.add(user);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error getUsers");
			e.printStackTrace();
		}
		
		return users;
		
	}
	
	public void deleteUser(int id){
		String query = "DELETE FROM usuarios WHERE (id=?)";
		
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error SQL");
			e.printStackTrace();
		}
	}
	
	public boolean insertUser(String nombre, String apellido, String email, String password){
		boolean result= false;
		String query = "INSERT INTO usuarios VALUES (?,?,?,?,?)";
		
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, 0);
			statement.setString(2, nombre);
			statement.setString(3, apellido);
			statement.setString(4, email);
			statement.setString(5, password);
			statement.executeUpdate();
			statement.close();
			result= true;
		} catch (SQLException e) {
			System.out.println("Error SQL");
			e.printStackTrace();
		}
		return result;
	}
	
	public void modUserAdmin(int id,String nombre, String apellido, String email, String password){
		String query = "UPDATE usuarios SET nombre=?, email=?, password=?, WHERE id=?";
		
		try {
			statement = conn.prepareStatement(query);
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setString(3, email);
			statement.setString(4, password);
			statement.setInt(7, id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error SQL");
			e.printStackTrace();
		}
	}
	
	public void modUser(int id, String nombre, String password, String descripcion){
		String query = "UPDATE usuarios SET nombre=?, password=?, descripcion=? WHERE id=?";
		
		try {
			statement = conn.prepareStatement(query);
			statement.setString(1, nombre);
			statement.setString(2, password);
			statement.setString(3, descripcion);
			statement.setInt(4, id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error SQL");
			e.printStackTrace();
		}
	}
	
	public Usuario getUser (int id){
		String query = "SELECT * FROM usuarios WHERE (id=?)";
		Usuario user=null;
		try {
			statement = conn.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet rs=statement.executeQuery();
			if (rs.next()) {
				user = new Usuario(rs.getInt("id"),rs.getString("nombre"),
						rs.getString("apellido"),rs.getString("email"),
						rs.getString("password"));
			}
		} catch (SQLException e){
			System.out.println("Error SQL");
			e.printStackTrace();
		}
		return user;
	}
}
