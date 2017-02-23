package proyecto_final.clases;

public class Producto {
	
	private int id,vendido,idVendedor;
	private String nombre,desc,precio;
	
	
	
	public Producto(int id, int vendido, int idVendedor, String nombre, String desc, String precio) {
		super();
		this.id = id;
		this.vendido = vendido;
		this.idVendedor = idVendedor;
		this.nombre = nombre;
		this.desc = desc;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVendido() {
		return vendido;
	}
	public void setVendido(int vendido) {
		this.vendido = vendido;
	}
	public int getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}

	
	
	
}
