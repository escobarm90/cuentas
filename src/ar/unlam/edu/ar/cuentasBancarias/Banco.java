package ar.unlam.edu.ar.cuentasBancarias;

import java.util.ArrayList;

public class Banco {
	
	private String nombre;
	private Integer contadorCuentas;
	private ArrayList<Cuenta> cuentas = new ArrayList<>(); 
	
	public Banco(String nombre) {
		this.nombre = nombre;
	}
	
	public Boolean agregarCuenta(Cuenta cuenta) {
		return this.cuentas.add(cuenta);
	}

	public Integer obtenerCantidadDeCuentas() {		
		return this.cuentas.size();		
	}
	
	public Cuenta buscarCuenta(Integer numeroDeCuenta) {
		for(Cuenta cuenta : cuentas) {
			if(numeroDeCuenta.equals(cuenta.getNumero())) {
				return cuenta;
			}
		}return null;
	}
	
	public void transferir(Integer numeroCuentaOrigen, Integer numeroCuentaDestino, Double monto) {
		Cuenta cuentaOrigen = buscarCuenta(numeroCuentaOrigen);	
		Cuenta cuentaDestino = buscarCuenta(numeroCuentaDestino);
		cuentaOrigen.retirar(monto);
		cuentaDestino.depositar(monto);
	}
}
