/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
//
//@author Laura Agudo Sánchez
//
public class Ingreso extends Dinero{
   	//inserta código aquí
	public Ingreso(double ingreso, String description) {
        this.dinero=ingreso;
        this.description=description;
    }
	@Override
    public String toString() {
		java.text.NumberFormat nf = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("es", "ES"));
        return "Ingreso [Descripción: "+this.getDescription()+
        		", Importe: "+nf.format(this.dinero)+ "]";
    }
}
