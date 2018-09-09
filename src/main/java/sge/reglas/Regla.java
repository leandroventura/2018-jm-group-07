package sge.reglas;

import java.util.List;
import java.util.function.Function;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import sge.dispositivos.inteligentes.DispositivoInteligente;

//import java.util.List;

@Entity
public class Regla {
	
	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	//private List<Sensor> sensoresADisposicion; //pensamos que seria en un futuro una lista de sensores y actuadores, pero por el momenton por falta de informacion al respecto, lo planteamos para uno solo.
	//private List<Actuador> actuadores;
	private Sensor sensorADisposicion;//ver relacion
	private Actuador actuador; //ver relacion
	
	private Function<Float,Boolean> funcion; //ver como persistir funciones
	
	
	public Regla(String nombre,Sensor sensor, Actuador actuador) {
		this.nombre = nombre;
		this.sensorADisposicion = sensor;
		this.actuador = actuador;
	}
	
	public Regla(String nombre, Actuador actuador) { //, Function<Float, Boolean> unaFuncion
		this.nombre = nombre;
		this.actuador = actuador;
		//this.funcion = unaFuncion;
	}
	
	public void setFuncion(Function<Float,Boolean> funcionACumplir) {
		this.funcion = funcionACumplir;
	}
	
	public void ejecutar(DispositivoInteligente dispositivo) { //con la medicion de un sensor
		float medicion = sensorADisposicion.medir();
		if(funcion.apply(medicion)) {
			actuador.accionar(dispositivo);
		}
		
	}
	
	public void ejecutar(float medicion, DispositivoInteligente dispositivo) {
		if(funcion.apply(medicion)) {
			actuador.accionar(dispositivo); //recibir la lista de dispositivos y pasarla como parametro
		}
	}
}
