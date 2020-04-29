
public class Funcionario {

	private String nome;
	private int matricula;
	private String cpf;
	private double salario;

	public Funcionario(String nome, int matricula, String cpf, double salario) {
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
		this.salario = salario;
	}

	// sobrescreve o metodo equals de object
	public boolean equals(Object obj) {
		// verifica se existe funcionario repetido pela igualdade da matricula
		if (obj instanceof Funcionario) {
			Funcionario existe = (Funcionario) obj;
			if (getMatricula() == existe.getMatricula()) {
				return true;
			} else {
				return false;
			}
		}
		return super.equals(obj);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getImpostoDeRenda() {
		return 0;
	}
}
