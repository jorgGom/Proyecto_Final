package proyecto_final.clases;

public class Producto {
	
	private int idproductos,vendido,vendedor,comprador;
	private String nombre,descripcion,precio;
	
	public Producto(int idproductos, int vendido, int vendedor, int comprador, String nombre, String descripcion,
			String precio) {
		super();
		this.idproductos = idproductos;
		this.vendido = vendido;
		this.vendedor = vendedor;
		this.comprador = comprador;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public int getIdproductos() {
		return idproductos;
	}
	public void setIdproductos(int idproductos) {
		this.idproductos = idproductos;
	}

	public int getVendido() {
		return vendido;
	}
	public void setVendido(int vendido) {
		this.vendido = vendido;
	}
	public int getComprador() {
		return comprador;
	}
	public void setComprador(int comprador) {
		this.comprador = comprador;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVendedor() {
		return vendedor;
	}
	public void setVendedor(int vendedor) {
		this.vendedor = vendedor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}

	
	
	
}
