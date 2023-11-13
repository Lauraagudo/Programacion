/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna otra clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
//
//@author Laura Agudo Sánchez
//

import java.util.*;

public class Cuenta {
   	//inserta código aquí
	private double saldo; //saldo de la cuenta
	private Usuario usuario; //usuario propietario de la cuenta
	private List<Gasto> gastos; //lista de gastos
    private List<Ingreso> ingresos; //lista de ingresos

    public Cuenta(Usuario usuario) { //Constructor único
        this.usuario = usuario;
        this.saldo = 0;
        this.ingresos = new ArrayList<Ingreso>();
        this.gastos = new ArrayList<Gasto>();
    }
    
    public double getSaldo() {
            return saldo;
    }
    
    public void setSaldo(double saldo) {
    	this.saldo=saldo;
    }

    public Usuario getUsuario() {
    	return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
    	this.usuario=usuario;
    } 
    
    public double addIngresos(String description, double cantidad) { //Agregar un ingreso a la cuenta
        Ingreso nuevoIngreso =new Ingreso (cantidad, description);
        this.ingresos.add(nuevoIngreso);
        this.saldo=this.saldo+cantidad;
        return saldo;
    }
    
    public double addGastos(String description, double cantidad) { //Agregar un gasto a la cuenta
    	try {
	    		if(this.saldo-cantidad<0) { //Si el saldo es menor que 0
	    			throw new GastoException(); //Sale el mensaje de GastoException
	    		}
	    		this.saldo=this.saldo-cantidad;
	    		Gasto nuevoGasto=new Gasto(cantidad, description);
		    	gastos.add(nuevoGasto);
		    	return saldo;
	    } catch (GastoException e) {
	    	System.out.println(e.getMessage());
			return -1;
	    }
    }
    
    public List<Ingreso> getIngresos() { //Para devolver la lista de ingresos
        return ingresos;
    }

    public List<Gasto> getGastos() { //Para devolver la lista de gastos
        return gastos;
    }
    
    public String toString() {
    	return ""+ this.getUsuario()+", Saldo actual ="+ this.saldo;
    }
}
