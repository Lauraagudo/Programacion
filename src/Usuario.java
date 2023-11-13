/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna otra clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
//
//@author Laura Agudo Sánchez
//
import java.util.regex.Pattern;
public class Usuario {
   	//inserta código aquí
	private String nombre;
    private int edad;
    private String DNI;

    public Usuario() {
		this.nombre= "";
		this.edad= 0;
		this.DNI= "";
		
	}
	public String getNombre() { //Devuelve el nombre
		return nombre;
	}
	public void setNombre(String nombre) { //Establece el nombre
		this.nombre= nombre;
	}
	public int getEdad() { //Devuelve la edad
		return edad;
	}
	public void setEdad(int edad) { //Establece la edad
		this.edad= edad;
	}
	public String getDNI() { //Devuelve el DNI
		return DNI;
	}
	
	public boolean setDNI(String DNI) {		//Establece el DNI y comprueba si es correcto
		String regex="^[0-9]{8}-?[a-z]{1}$";
		Pattern patron=Pattern.compile(regex);
		if(patron.matcher(DNI).matches()) {
			this.DNI=DNI;
			return true;
		}
		return patron.matcher(DNI).matches();
		}
	@Override
	public String toString() {
		return "Nombre: "+ this.nombre+
				" Edad: "+ this.edad+
				" DNI: "+ this.DNI;
	}
}