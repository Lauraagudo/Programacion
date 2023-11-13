/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
//
//@author Laura Agudo Sánchez
//
@SuppressWarnings("serial")
	class GastoException extends Exception{
   	//inserta código aquí
	public GastoException() { 
		super ("La cantidad del gasto excede el saldo de su cuenta");
}
}