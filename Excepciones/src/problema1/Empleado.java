package problema1;

public class Empleado {
	//Atributos de la clase
	private String cedula;
    private String nombre;
    private String departamento;
    private double salarioBruto;
    
    //Constructor
    public Empleado(String cedula, String nombre, String departamento, double salarioBruto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salarioBruto = salarioBruto;
    }

    //Getters
    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    //Seguro Social
    public double calcularSeguroSocial() {
    	return salarioBruto * 0.0975;
    }
    
    //Seguro Educativo
    public double calcularSeguroEducativo() {
    	return salarioBruto * 0.0125;
    }
    
    //Salario Neto
    public double calcularSalarioNeto(double descuentosAdicionales) {
        return salarioBruto - calcularSeguroSocial() - calcularSeguroEducativo() - descuentosAdicionales;
    }
}
