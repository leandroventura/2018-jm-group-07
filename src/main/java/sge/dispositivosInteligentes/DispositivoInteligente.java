package sge.dispositivosInteligentes;

import sge.dispositivos.*;
import java.util.List;

public class DispositivoInteligente extends Dispositivo {
	private EstadoDispositivo estado; //aca podriamos usar un repo de estados, para no tener que andar instanciando todo el tiempo
	private double IDFabrica = (Math.random() * 100000) + 1; //deberia cambiarse dsps y meter los nros generados en una lista, para comprobar que no se repitan
	private List<Sensor> sensores;
	private List<Actuador> actuadores;
	private List<Regla> reglas;

	public DispositivoInteligente(String nombre, double consumoKWxHora) {
		this.nombre = nombre;
		this.consumoKWxHora = consumoKWxHora;
		this.estado = new Apagado(); //el dispositivo inicia apagado
	}
	
	public double consumoMensual() {
		return consumoTotalUnPeriodo(30); //el 30 seria la cantidad de dias del mes
	}

	public double consumoDuranteUltimasHoras(int cantHoras) {
		return consumoKWxHora * cantHoras;
	}

	public double consumoTotalUnPeriodo(int dias) {
		return consumoKWxHora * 24 * dias; // el 24 refiere a las 24 hs de un dia
		//aca habria que hacer una limitiacion de ctos dias como maximo se puede volver atras, que calculo que el maximo atras debe ser 30 dias (1 mes)
	}

	public boolean encendido() {
		return estado.encendido();
	}
	
	public boolean apagado() {
		return !estado.encendido();
	}

	public void cambiarEstado(EstadoDispositivo estado) {
		this.estado = estado;
	}

	public void apagar() {
		estado.apagarse(this);
	}

	public void encender() {
		estado.encenderse(this);
	}
	
	public void establecerModoAhorroDeEnergia() {
		estado.entrarEnModoAhorroDeEnergia(this);
	}
	
	public int puntosPorAgregarDisp() {
		return 15;
	}
}
