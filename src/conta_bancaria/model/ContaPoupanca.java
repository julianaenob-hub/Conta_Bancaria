package conta_bancaria.model;

public class ContaPoupanca extends Conta {
	
	private int dataAniversario;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int dataAniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.dataAniversario = dataAniversario;
	}

	public int getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(int dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Aniversario da conta: " + this.dataAniversario);
	}


	}


