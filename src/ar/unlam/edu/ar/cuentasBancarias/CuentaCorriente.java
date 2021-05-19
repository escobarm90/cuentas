package ar.unlam.edu.ar.cuentasBancarias;

public class CuentaCorriente extends Cuenta {
	
	private final Double LIMITE_DESCUBIERTO = 150.0;
	private final Double COMISION_DESCUBIERTO = 0.05;
	
	public CuentaCorriente(Integer numeroDeCuenta,Double saldo){
		super(numeroDeCuenta,saldo);
	}
	
	@Override
	public Boolean retirar(Double d) {
		Double disponible=0.0;
		Double descubierto = 0.0;
		if (this.getSaldo() > 0 && this.getSaldo() >= d) {
			this.setSaldo(this.getSaldo() - d);
			return Boolean.TRUE;
		}if(d > this.getSaldo() ) {
			disponible = LIMITE_DESCUBIERTO + this.getSaldo();
			descubierto = this.getSaldo() - d;
		}if(disponible >= d) {
			this.setSaldo(this.getSaldo() - d + (descubierto*COMISION_DESCUBIERTO));
			return Boolean.TRUE;
		}return Boolean.FALSE;
	}

}
