package ar.unlam.edu.ar.cuentasBancarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestBanco {

	@Test
	public void queSePuedaAgregarUnaCuenta() {
		String nombre = "Unlam";
		Banco unlam = new Banco(nombre);
		CajaDeAhorro cuenta = new CajaDeAhorro(1234, 1000.0);
		CajaDeAhorro cuenta2 = new CajaDeAhorro(1235, 1000.0);
		
		unlam.agregarCuenta(cuenta);
		unlam.agregarCuenta(cuenta2);
		
		assertEquals(2,unlam.obtenerCantidadDeCuentas(),0.1);
		
	}
	
	@Test
	public void queSePuedaTransferirEntreDosCuentas() {
		
		String nombre = "Unlam";
		Banco unlam = new Banco(nombre);
		CajaDeAhorro cuenta = new CajaDeAhorro(1234, 1000.0);
		CajaDeAhorro cuenta2 = new CajaDeAhorro(1235, 1000.0);
		
		unlam.agregarCuenta(cuenta);
		unlam.agregarCuenta(cuenta2);
		
		Integer numeroCuentaOrigen = 1234;
		Integer numeroCuentaDestino = 1235;
		Double monto = 500.0;
		
		unlam.transferir(numeroCuentaOrigen, numeroCuentaDestino, monto);
		
		assertEquals(cuenta.getSaldo(), 500.0,0.1);
		assertEquals(cuenta2.getSaldo(), 1500.0, 0.1);
	}
}
