/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
//
//@author Laura Agudo Sánchez
//
public class Gasto extends Dinero {
   	//inserta código aquí
	 public Gasto(double gasto, String description) {
	        this.dinero = gasto;
	        this.description=description;
	    }
	 @Override
	    public String toString() {
	        return "Gasto: [Descripción: "+this.getDescription()+
	        		", Importe: "+this.dinero;
	    }
	}