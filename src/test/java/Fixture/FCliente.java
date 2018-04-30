package Fixture;
import java.util.ArrayList;

import org.junit.Before;

import org.mockito.Mockito;

import sge.Documento;
import sge.TipoDocumento;
import sge.categorias.Categoria;
import sge.categorias.CategoriaResidencial;
import sge.clientes.Cliente;
import sge.dispositivos.Dispositivo;

public class FCliente {
	
	protected Cliente clienteSinDispositivos;
	protected Cliente clienteConUnDispositivo;
	protected Cliente clienteConDosDispositivos;
	protected Cliente clienteMock;
	
	@Before
	public void init() {
		Dispositivo tv = new Dispositivo("TV", 0.6, false);
		Dispositivo heladera = new Dispositivo("Heladera", 0.6, true);
		Categoria r3 = new CategoriaResidencial(60.71, 0.681, 325, 400);
		ArrayList<Dispositivo> dosDispositivos = new ArrayList<Dispositivo>();
		dosDispositivos.add(tv);
		dosDispositivos.add(heladera);
		clienteConDosDispositivos = new Cliente("Martin Perez",
				new Documento(40732178, TipoDocumento.DNI), "Belgrano 2251", "01149212334", r3, dosDispositivos);
		ArrayList<Dispositivo> sinDispositivos = new ArrayList<Dispositivo>();
		clienteSinDispositivos = new Cliente("Juan Lopez",
				new Documento(40732178, TipoDocumento.DNI), "Santa Fe 1781", "01141131234", r3, sinDispositivos);
		ArrayList<Dispositivo> unDispositivo = new ArrayList<Dispositivo>();
		unDispositivo.add(tv);
		clienteConUnDispositivo = new Cliente( "Pepe Mitre" ,
				new Documento(40732178, TipoDocumento.DNI), "Belgrano 241", "01149231234", r3, unDispositivo);
		clienteMock = Mockito.spy(clienteConUnDispositivo);
		
	}
	
	
}
