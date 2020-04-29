
public class Professor extends Funcionario {

	private int anoDeAdmissao;

	// construtor inicializando os dados do professor
	public Professor(String nome, int matricula, String cpf, double salario, int anoDeadmissao) {
		super(nome, matricula, cpf, salario);
		this.anoDeAdmissao = anoDeadmissao;
	}

	public int getAnoDeAdmisao() {
		return anoDeAdmissao;
	}

	public void setAnoDeAdmisao(int anoDeAdmisao) {
		this.anoDeAdmissao = anoDeAdmisao;
	}

	//sobrescreve metodo getImpostoRenda herdado de Funcionario
	public double getImpostoDeRenda() {
		return getSalario() * 0.2;
	}

	// sobrescreve metodo toString
	public String toString() {
		return "Nome: " + super.getNome() 
		+ " Matricula: " + super.getMatricula() 
		+ " Cpf: " + super.getCpf()
		+ " Salario: " + super.getSalario() 
		+ " Ano de Admissao: " 
		+ this.anoDeAdmissao + ".";
	}

}
