package ar.unlam.edu.ar.cuentasBancarias;

public class Cuenta {
	
	private Double saldo;
	private Integer numeroDeCuenta;
	private String tipoDeCuenta;
	
	public Cuenta(Integer numeroDeCuenta,Double saldo) {
		this.saldo = saldo;
		this.numeroDeCuenta = numeroDeCuenta;
	}

	public void depositar(Double d) {
		this.saldo+=d;		
	}
	
	public Double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(Double d) {
		this.saldo = d;
	}
	
	public Integer getNumero() {
		return this.numeroDeCuenta;
	}

	public Boolean retirar(Double d) {
		if (this.saldo > 0 && this.saldo >= d) {
			this.saldo -= d;
			return Boolean.TRUE;
		} else
			return Boolean.FALSE;
	}
	
	
}
