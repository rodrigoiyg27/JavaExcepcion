package problema1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	//Variables
	String cedula, nombre, departamento;
	double salarioBruto, descuentosAdicionales;
	
	//Funciones de validación
	public String validarNoVacio(String valor, String campo) throws Excepcion {
		if (valor.isEmpty()) {
    		throw new Excepcion("El campo " + campo + " no puede estar en blanco.");
    		}
    	return valor;
    	}
	
	public String validarLetra(String valor, String campo) throws Excepcion {
		for (char c : validarNoVacio(valor, campo).toCharArray()) {
			if (Character.isDigit(c)) {
				throw new Excepcion("El campo " + campo + " no puede contener números.");
				}
			}
		return valor;
		}
	
	public String validarCedula(String valor, String campo) throws Excepcion {
		for (char c : validarNoVacio(valor, campo).toCharArray()) {
			if (!Character.isDigit(c) && c != '-') {
				throw new Excepcion("El campo " + campo + " no puede contener letras, solo guiones y números.");
				}
			}
		return valor;
		}
	
	public double validarNoNegativo(double valor, String campo) throws Excepcion {
		if (valor < 0) {
			throw new Excepcion("El campo " + campo + " no puede contener un número negativo." );
			}
		return valor;
		}
	
	//Funciones para la impresión horizontal
	public String imprimirCentrado(String valor, int espacio) {
		int espacios;
		int espacioIzq;
		int espacioDer;
		
		espacios = espacio - valor.length();
		espacioIzq = espacios / 2;
		espacioDer = espacios - espacioIzq;
		
		return String.format("%" + espacioIzq + "s%s%" + espacioDer + "s", "", valor, "");
	}
	
	public String imprimirCentrado(double valor, int espacio) {
		String valorString;
		int espacios;
		int espacioIzq;
		int espacioDer;
		
		valorString = String.format("%.2f", valor);
		espacios = espacio - valorString.length();
		espacioIzq = espacios / 2;
		espacioDer = espacios - espacioIzq;
		
		return String.format("%" + espacioIzq + "s%s%" + espacioDer + "s", "", valorString, "");
	}
	
	//Ejecución del programa
	public static void main(String[] args) throws Excepcion, IOException {
		Main main = new Main();
		main.obtenerDatos();
		}
	
	public void obtenerDatos() throws Excepcion, IOException {
		
		//Creación del lector de datos
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			//Entrada de datos
			System.out.print("\nIngrese la cédula: ");
			cedula = validarCedula(reader.readLine(),"cédula");
  
			System.out.print("Ingrese el nombre: ");
			nombre = validarLetra(reader.readLine(), "nombre");
        
			System.out.print("Ingrese el departamento: ");
			departamento = validarLetra(reader.readLine(), "departamento");
        
			System.out.print("Ingrese el salario bruto: ");
			salarioBruto = Double.parseDouble(validarNoVacio(reader.readLine(), "salario bruto"));
			salarioBruto = validarNoNegativo(salarioBruto, "salario bruto");
        
			System.out.print("Ingrese el total de descuentos adicionales: ");
			descuentosAdicionales = Double.parseDouble(validarNoVacio(reader.readLine(), "descuentos adicionales"));
			descuentosAdicionales = validarNoNegativo(descuentosAdicionales, "descuentos adicionales");
        
			//Creación del objeto empleado
			Empleado empleado1 = new Empleado(cedula, nombre, departamento, salarioBruto);
        
	        System.out.println("\nDATOS DEL EMPLEADO");
	        System.out.println("Cédula: " + empleado1.getCedula());
	        System.out.println("Nombre: " + empleado1.getNombre());
	        System.out.println("Departamento: " + empleado1.getDepartamento());
	        
	        System.out.println("\n|" + imprimirCentrado("Salario Bruto", 15) + "|" + imprimirCentrado("Seguro Social", 15) + "|" + imprimirCentrado("Seguro Educativo", 20) + "|" + imprimirCentrado("Descuentos Adicionales", 25) + "|" + imprimirCentrado("Salario Neto", 15) + "|");
	        System.out.println("|" + imprimirCentrado(salarioBruto, 15) + "|" + imprimirCentrado(empleado1.calcularSeguroSocial(), 15) + "|" + imprimirCentrado(empleado1.calcularSeguroEducativo(), 20) + "|" + imprimirCentrado(descuentosAdicionales, 25) + "|" + imprimirCentrado(empleado1.calcularSalarioNeto(descuentosAdicionales), 15) + "|");
	    	
	    	//Manejo de excepciones
	    	}
		catch (IOException e) {
			System.out.println("Error de entrada/salida: " + e.getMessage());
	    	Main main = new Main();
	    	main.obtenerDatos();
	    	}
		catch (NumberFormatException e) {
			System.out.println("Error en el formato de número. " + "Asegúrese de ingresar valores numéricos. " + e.getMessage());
			Main main = new Main();
			main.obtenerDatos();
			}
		catch (Excepcion e) {
			System.out.println("Error: " + e.getMessage());
			Main main = new Main();
			main.obtenerDatos();
		}
		finally {
			try {
				reader.close();
				}
			catch (Exception e) {
				System.out.println("Error al cerrar el lector: " + e.getMessage());
				}
			}
		}
	}
