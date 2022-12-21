package Programa_Zoo;

public abstract class Animal {

	protected String alimentacion, habitat, temperamento, tipo, reproduccion;
	protected int cantidad;
	
    //Constructor
	public Animal(String tipo, String reproduccion, String alimentacion, String temperamento, String habitat, int cantidad) {
		
		this.tipo = tipo;
		this.reproduccion = reproduccion;
		this.alimentacion = alimentacion;
		this.temperamento = temperamento;
		this.habitat = habitat; 
	    this.cantidad = cantidad; }

	//Getters
	public String getAlimentacion() {
		return alimentacion;
	}

	public String getHabitat() {
		return habitat;
	}

	public String getTemperamento() {
		return temperamento;
	}

	public String getTipo() {
		return tipo;
	}

	public String getReproduccion() {
		return reproduccion;
	}

	public int getCantidad() {
		return cantidad;
	}
	
}
