package ar.unlam.edu.ar.cuentasBancarias;

import org.junit.Assert;
import org.junit.Test;

public class TestCuentas {
	
	@Test
	public void queSePuedaCrearUnaCuentaSueldo(){
		Double saldo = 5000.0;
		Integer numeroDeCuenta = 000001;
		String tipoDeCuenta = "Cuenta Sueldo";
		Cuenta miCuenta = new Cuenta(numeroDeCuenta,saldo);
		
		Assert.assertNotNull(miCuenta);
		
	}
	
	@Test
	public void queSePuedaDepositarDinero() {
		Double saldo = 5000.0;
		Integer numeroDeCuenta = 000001;
		String tipoDeCuenta = "Cuenta Sueldo";
		Cuenta miCuenta = new Cuenta(numeroDeCuenta,saldo);
		miCuenta.depositar(500.0);
		
		Assert.assertEquals(miCuenta.getSaldo(),5500.0,0.1);
	}
	
	@Test
	public void queSePuedaRetirarDinero() {		
		Double saldo = 5000.0;
		Integer numeroDeCuenta = 000001;
		String tipoDeCuenta = "Cuenta Sueldo";
		Cuenta miCuenta = new Cuenta(numeroDeCuenta,saldo);
		miCuenta.retirar(500.0);
		
		Double testOk = miCuenta.getSaldo();
		Assert.assertEquals(testOk,4500.0,0.1);
	}
	
	@Test
	public void queNoSePuedaRetirarMasDineroDelQueHayEnLaCuenta() {
		Double saldo = 5000.0;
		Integer numeroDeCuenta = 000001;
		String tipoDeCuenta = "Cuenta Sueldo";
		Cuenta miCuenta = new Cuenta(numeroDeCuenta,saldo);
			
			Assert.assertFalse(miCuenta.retirar(6000.0));
	}
	
	@Test
	public void queSePuedaCrearUnaCajaDeAhorros(){
		Double saldo = 5000.0;
		Integer numeroDeCuenta = 000001;
		String tipoDeCuenta = "Cuenta Sueldo";
		CajaDeAhorro miCajaDeAhorro = new CajaDeAhorro(numeroDeCuenta,saldo);
		
		Assert.assertNotNull(miCajaDeAhorro);
	}
	
	@Test
	public void queCajaDeAhorrosCobreElAdicionalSiCorresponde(){
		Double saldo = 5000.0;
		Integer numeroDeCuenta = 000001;
		String tipoDeCuenta = "Cuenta Sueldo";
		CajaDeAhorro miCajaDeAhorro = new CajaDeAhorro(numeroDeCuenta,saldo);
		
		miCajaDeAhorro.retirar(1.0);
		miCajaDeAhorro.retirar(1.0);
		miCajaDeAhorro.retirar(1.0);
		miCajaDeAhorro.retirar(1.0);
		miCajaDeAhorro.retirar(1.0);
		
		Double testOk1 = 4995.0;
		
		Assert.assertEquals(testOk1,miCajaDeAhorro.getSaldo() , 0.1);
		
		miCajaDeAhorro.retirar(2.0);
		miCajaDeAhorro.retirar(2.0);
		
		Double testOk2 = 4985.0;
		
		Assert.assertEquals(testOk2,miCajaDeAhorro.getSaldo() , 0.1);
		
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaCorriente() {
		Double saldo = 5000.0;
		Integer numeroDeCuenta = 000001;
		String tipoDeCuenta = "Cuenta Corriente";
		CuentaCorriente miCuentaCorriente = new CuentaCorriente(numeroDeCuenta,saldo);
		
		Assert.assertNotNull(miCuentaCorriente);
	}
	
	@Test
	public void queSePuedaRetirarCONfondosDeUnaCuentaCorriente() {
		Double saldo = 5000.0;
		Integer numeroDeCuenta = 000001;
		String tipoDeCuenta = "Cuenta Corriente";
		CuentaCorriente miCuentaCorriente = new CuentaCorriente(numeroDeCuenta,saldo);
		
		 miCuentaCorriente.retirar(2500.00);
		 Double testOk = 2500.0;
		Assert.assertEquals(miCuentaCorriente.getSaldo(),testOk,0.1);
	}
	
	@Test
	public void queSePuedaRetirarSINfondosDeUnaCuentaCorriente() {
		Double saldo = 5000.0;
		Integer numeroDeCuenta = 000001;
		String tipoDeCuenta = "Cuenta Corriente";
		CuentaCorriente miCuentaCorriente = new CuentaCorriente(numeroDeCuenta,saldo);
		
		 miCuentaCorriente.retirar(5100.0);
		 Double testOk = -105.0;
		Assert.assertEquals(testOk,miCuentaCorriente.getSaldo(),0.1);
	}
		


}