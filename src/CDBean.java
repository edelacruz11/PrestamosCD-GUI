public class CDBean implements Comparable<CDBean> {
	
	String titulo, autor, genero, prestamo;
	
	public CDBean(String titulo, String autor, String genero, String prestamo) {
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.prestamo = prestamo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getPrestamo() {
		return prestamo;
	}
	
	public void setPrestamo(String prestamo) {
		this.prestamo = prestamo;
	}
	
	public String toString() {
		return titulo;
	}

	@Override
	public int compareTo(CDBean arg0) {
		String otroTitulo = arg0.getTitulo();
		return titulo.compareToIgnoreCase(otroTitulo);
	}
	
}	