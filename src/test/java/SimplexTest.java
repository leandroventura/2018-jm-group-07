import static org.junit.Assert.assertEquals;

import org.junit.Test;

import sge.simplex.ProcesoSimplex;
import sge.simplex.ResultadoSimplex;
import sge.simplex.SgeSimplex;


public class SimplexTest extends Fixture.FSimplex {

	@Test
	public void testOptimizarUnAire() {
		ResultadoSimplex res = clienteConUnAire.consumoIdeal();
		assertEquals("Un cliente con un solo aire se optimiza a las horas maximas", unAire.get(0).getMaximo(), res.horasOptimasDisps.get(0));
	}

	@Test
	public void testOptimizarCuatroAires() {
		ResultadoSimplex res = clienteConCuatroAires.consumoIdeal();
		assertEquals("Un cliente con cuatro", SgeSimplex.consumoMaximo, res.horasTotales* unAire.get(0).consumoKWxHora(), 0.5);
	}
	@Test
	public void testSimplexAutomatico() {
		ProcesoSimplex.ejecutar();
		assertEquals("El aire no se pasa del consumo mensual, por lo tanto no lo debe apagar",0, clienteConUnAire.cantidadDispositivosApagados());
	}
}