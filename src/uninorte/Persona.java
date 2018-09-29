package uninorte;

public class Persona {
	  String nombre, apellido, direccion, telefono, correo;

		public Persona(String nombre, String apellido) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
		}
		
		public String getDireccion() {
			return direccion;
		}
		
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		
		public String getTelefono() {
			return telefono;
		}
		
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		
		public String getCorreo() {
			return correo;
		}
		
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		
		public String getNombreCompleto() {
			 return this.nombre + " " +this.apellido;
		}
}
