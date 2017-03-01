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
		String query = "SELECT * FROM usuario WHERE nombre=? AND contraseña=?";
		try {
			statement = conn.prepareStatement(query);
			statement.setString(1, nombre);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {	u = new Usuario(rs.getInt("idusuario"),rs.getString("nombre"),
						rs.getString("apellido"),rs.getString("email"),
						rs.getString("contraseña"));
			statement.close();}
		} catch (SQLException e) {
			System.out.println("Error: Validate User");
			e.printStackTrace();
		}
		return u;
	}
	
	public List<Usuario> readUsers(){
		List <Usuario> users=new ArrayList<>();
		
		String query = "SELECT * FROM usuario";
		try {
			statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()){
				Usuario user = new Usuario(rs.getInt("idusuario"),rs.getString("nombre"),
						rs.getString("apellido"),rs.getString("email"),
						rs.getString("contraseña"));
				users.add(user);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error getUsers");
			e.printStackTrace();
		}
		
		return users;
		
	}
	
	public void deleteUser(int idusuario){
		String query = "DELETE FROM usuario WHERE (idusuario=?)";
		
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, idusuario);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error SQL");
			e.printStackTrace();
		}
	}
	
	public boolean insertUser(String nombre, String apellido, String email, String password){
		boolean result= false;
		String query = "INSERT INTO usuario VALUES (?,?,?,?,?)";
		
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
	
	public void modUser(int idusuario, String nombre, String apellido,String email, String password){
		String query = "UPDATE usuario=? SET nombre=?, apellido=?, email=?, contraseña=? WHERE idusuario=?";
		
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, idusuario);
			statement.setString(2, nombre);
			statement.setString(3, apellido);
			statement.setString(4, email);
			statement.setString(5, password);
			statement.setInt(6, idusuario);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error SQL");
			e.printStackTrace();
		}
	}
	
	public Usuario getUser (int idusuario){
		String query = "SELECT * FROM usuario WHERE (idusuario=?)";
		Usuario user=null;
		try {
			statement = conn.prepareStatement(query);
			statement.setLong(1, idusuario);
			ResultSet rs=statement.executeQuery();
			if (rs.next()) {
				user = new Usuario(rs.getInt("idusuario"),rs.getString("nombre"),
						rs.getString("apellido"),rs.getString("email"),
						rs.getString("contraseña"));
			}
		} catch (SQLException e){
			System.out.println("Error SQL");
			e.printStackTrace();
		}
		return user;
	}
}
