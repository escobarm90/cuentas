package ar.unlam.edu.ar.cuentasBancarias;

public class CajaDeAhorro extends Cuenta {

	Integer cantidadDeExtracciones;
	
	public CajaDeAhorro(Integer numeroDeCuenta,Double saldo) {
		super(numeroDeCuenta,saldo);
		this.cantidadDeExtracciones = 0;
	}
	
	
	@Override
	public Boolean retirar(Double d) {
		if (this.getSaldo() > 0 && this.getSaldo() >= d && this.cantidadDeExtracciones <=5) {
			this.setSaldo(this.getSaldo() - d);
			this.cantidadDeExtracciones++;
			return Boolean.TRUE;
		} else if(this.getSaldo() >= d && this.cantidadDeExtracciones>5) {
			this.setSaldo(this.getSaldo() -d);
			this.setSaldo(this.getSaldo() - 6.0);
			this.cantidadDeExtracciones++;
			return Boolean.TRUE;
		}
			return Boolean.FALSE;
	}
}
