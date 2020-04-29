
public class Diretor extends Funcionario {

	private double tempoDeCasa;

	// construtor inicializando os dados do professor
	public Diretor(String nome, int matricula, String cpf, double salario, double tempoDeCasa) {
		super(nome, matricula, cpf, salario);
		this.tempoDeCasa = tempoDeCasa;
	}

	public double getTempoDeCasa() {
		return tempoDeCasa;
	}

	public void setTempoDeCasa(double tempoDeCasa) {
		this.tempoDeCasa = tempoDeCasa;
	}

	// sobrescreve metodo getImpostoRenda herdado de Funcionario
	public double getImpostoDeRenda() {
		return getSalario() * 0.23;
	}

	// sobrescreve metodo toString
	public String toString() {
		return "Nome: " + super.getNome() + " Matricula: " + super.getMatricula() + " Cpf: " + super.getCpf()
				+ " Salario: " + super.getSalario() + " Tempo de Casa: " + this.tempoDeCasa + " meses.";
	}

}
