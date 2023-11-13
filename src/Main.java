/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna otra clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
//
//@author Laura Agudo Sánchez
//
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
    	//inserta código aquí
    	Usuario usuario=null;
    	do {
    		usuario=LeerUsuario();
    	}while(usuario==null);
    	System.out.println(usuario.toString());
    	
    	Cuenta cuenta=new Cuenta(usuario);  //Creamos la cuenta
    	mostrarMenu(cuenta); //Mostramos el menú de opciones
    }
    
/**** Mostrar las distintas opciones validas del Menu de Opciones ****/
    public static void mostrarMenu(Cuenta cuenta){
    	//inserta código aquí
    	boolean salir = false;
    	int opcion;
    	Scanner sc = new Scanner(System.in);
    	sc.useLocale(Locale.forLanguageTag("es-ES"));
    	while(!salir) {
            System.out.println(" Realizar una nueva acción:");
            System.out.println("  (1) Introducir un nuevo gasto");
            System.out.println("  (2) Introducir un nuevo ingreso");
            System.out.println("  (3) Mostrar gastos");
            System.out.println("  (4) Mostrar ingresos");
            System.out.println("  (5) Mostrar saldo");
            System.out.println("  (0) Salir");
            try {
	            opcion = sc.nextInt();;
	            sc.nextLine();
	            	switch(opcion) { //desde el caso 1 al 5 se llama a los métodos correspondientes
	            	case 1:
	            		addGastos(cuenta);
	            		break;     	
	            	case 2:
	            		addIngresos(cuenta);
	            		break;
	            	case 3:
	            		imprimirGastos(cuenta);
	            		break;
	            	case 4:
	            		imprimirIngresos(cuenta);
	            		break;
	            	case 5:
	            		NumberFormat nf= NumberFormat.getCurrencyInstance(new Locale("es","ES"));
	            		System.out.println(cuenta.toString()+"€");
	            		break;
	            	case 0:
	            		salir=true;
	            		System.out.println("Fin del programa.");
	            		System.out.println("Gracias por utilizar la aplicación de M03B en el curso 1s2223");
	            		break;
	            	default:
	            		System.out.println("Opción no válida, escoge de nuevo:");
	            	}
            }catch (InputMismatchException e) {
            	System.out.println ("Opción no válida, escoge de nuevo:");
            sc.next();
            }
    	}
    }
    
    // Método para comprobar si un string es un entero.
    private static boolean esEntero(String valor) {
        valor=valor.replace(',','.'); //reemplazar coma por punto
    	try {
            Double.parseDouble(valor); //intenta convertir un valor a un double
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("Valor no válido");
            return false;
        }
        }

    private static double leerCantidad() {
    	boolean cantidadCorrecta=false; 
    	double valor=0; //se inica como 0 y almacenará la cantidad introducida
    	Scanner lectura=new Scanner(System.in);
    	do {
    		System.out.println("Introduce la cantidad:");
    		try {
    			valor=lectura.nextDouble(); //se lee el valor
    			cantidadCorrecta=true; //si el valor es correcto
    		} catch (InputMismatchException errorTipo) { //si el valor es incorrecto
    			cantidadCorrecta=false;
    			lectura.nextLine();
    			System.out.println("Las cantidades deben de ir en formato europeo ####,##");
    		}
    	}while (!cantidadCorrecta);
    	lectura.nextLine();
    	return valor;
    }
    
/**** Función que lee por teclado los datos del usuario y los devuelve como un objeto de tipo Usuario. ****/
    private static Usuario LeerUsuario(){
    	//inserta código aquí
    	Scanner sc=new Scanner(System.in); //lee la entrada del usuario
    	Usuario usuario=new Usuario();
    	
    	System.out.println("Introduzca un nombre:");
    	String nombre= sc.nextLine();
    	
    	System.out.println("Introduzca la edad: ");
	    int edad;
	   	String xEdad;
		    do {
		   		xEdad=sc.nextLine();
		   	} while(!esEntero(xEdad));
		   	edad=Integer.parseInt(xEdad);
    	
    	System.out.println("Introduzca su DNI:");
	   	String dni;
		do {
	    	dni=sc.nextLine();
	   		if (usuario.setDNI(dni)) {
    			System.out.println("Usuario Creado correctamente");
		    	}else {
		    		System.out.println("DNI no válido, introduce correcto:");
		    	}
		   	}while (!usuario.setDNI(dni));
		
		    usuario.setNombre(nombre);
		    usuario.setEdad(edad);
		    usuario.setDNI(dni); 
		    	
		    return usuario;
    }
    
/**** Funcion que lee por teclado un ingreso, lo agrega a la lista de ingresos y muestra mensaje ****/
    private static void addIngresos(Cuenta cuenta){
    	double cantidad;
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.forLanguageTag("es-ES")); //para que los números con coma sean interpretados correctamente
		
    	System.out.println("Introduzca la descripción del ingreso: ");
		String description = sc.nextLine();
		
		cantidad=leerCantidad();
		
		//Agregar ingreso a la cuenta
		cuenta.addIngresos(description, cantidad);
		System.out.println("Ingreso agregado correctamente.");
    }
    
/**** Muestra por pantalla el listado de ingresos ****/
    private static void imprimirIngresos(Cuenta cuenta){
    	NumberFormat nf=NumberFormat.getCurrencyInstance(); //formatear cantidades como monedas
    	double tIngresos=0; //variable para almacenar el total de los ingresos
    	
		for (Ingreso i:cuenta.getIngresos()) {
			System.out.println(i.toString());
			tIngresos+= i.getDinero(); //acumula el ingreso 
		}
		System.out.println("Total ingresos= "+ nf.format(tIngresos)+ "\n");
    }
    
/**** Funcion que lee por teclado un Gasto y lo agrega a la lista de gastos y muestra mensaje ****/
    private static void addGastos(Cuenta cuenta){
    	Scanner sc = new Scanner(System.in);
    	sc.useLocale(Locale.forLanguageTag("es-ES")); //para que los números con coma sean interpretados correctamente
    	
    	System.out.println("Introduzca la descripción del gasto:");
        String description = sc.nextLine();
        double cantidad;
        cantidad=leerCantidad();
        
    //Agregar gasto a la cuenta
        cuenta.addGastos(description, cantidad);
        System.out.println("Gasto agregado correctamente");
    }
    
/**** Muestra por pantalla el listado de gastos ****/
    private static void imprimirGastos(Cuenta cuenta){
    	NumberFormat nf=NumberFormat.getCurrencyInstance(); //formatear cantidades como monedas
    	double tGastos=0;//variable para almacenar el total de los gastos
    	
		for (Gasto g:cuenta.getGastos()) {
			System.out.println(g.toString());
			tGastos+= g.getDinero();//acumula el gasto 
		}
		System.out.println("\nTotal gastos= "+ nf.format(tGastos)+ "\n");
    }
}
