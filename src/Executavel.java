import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

@SuppressWarnings({"all"})

public class Executavel {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		ArrayList<Funcionario> relacaoDeFuncionarios = new ArrayList<>();

		char continua;  // declara variavel de continuidade
		
		// executa a inclusao de funcionarios ate o usuario pressionar 'n'

		do { // recebe do usuario os dados do funcionario
			String nome = lerString("Digite o nome do funcionario: ");
			String cpf = lerString("Digite o cpf: ");
			double salario = lerDouble("Digite o salario: ");
			int matricula = lerInt("Digite a matricula: ");
			char cargo = lerChar("Digite o cargo: ('d' - DIRETOR / 'P' - PROFESSOR) ");

			double tempoDeCasa = 0;
			int anoDeAdmissao = 0;

			if (cargo == 'd') {
				tempoDeCasa = lerDouble("Informe o tempo de casa em meses:");
			} else {
				anoDeAdmissao = lerInt("Informe o ano de admissao:");
			}

			//valida o cargo, se o funcionario é repetido e insere no array quando validacoes ok
			boolean cadastroRepetido = false;

			if (cargo == 'd') {
				Diretor d1 = new Diretor(nome, matricula, cpf, salario, tempoDeCasa); // verifica se existe funcionario repetido com equals
				for (int i = 0; i < relacaoDeFuncionarios.size(); i++) {
					if (d1.equals(relacaoDeFuncionarios.get(i))) {
						cadastroRepetido = true;
					}
				}
				if (cadastroRepetido) {
					lermsg("Funcionario ja existe, cadastro NAO realizado!");
				} else { // inclui no array um Diretor
					relacaoDeFuncionarios.add(d1);
					lermsg("Cadastro realizado!");
					lermsg(d1.toString());
				}

			} else if (cargo == 'p') {
				Professor p1 = new Professor(nome, matricula, cpf, salario, anoDeAdmissao);  // verifica se existe funcionario repetido com equals
				for (int i = 0; i < relacaoDeFuncionarios.size(); i++) {
					if (p1.equals(relacaoDeFuncionarios.get(i))) {
						cadastroRepetido = true;
					}
				}

				if (cadastroRepetido) {
					lermsg("OPS... Funcionario ja cadastrado!");
				} else {
					relacaoDeFuncionarios.add(p1);  // inclui no array um professor
					lermsg("Cadastro realizado com sucesso!");
					lermsg(p1.toString());  // exibe dados do funcionario cadastrado via toString
				}

			} else {  // caso cargo diferente de 'd' ou 'p' exibe erro
				lermsg("Cargo NAO existe, tente novamente");
			}

			continua = lerChar("Deseja continuar?(s/n) ");

		} while (continua != 'n');

		double totalImpostoRenda = 0;
		double mediaImpostoRenda = 0;

		for (int i = 0; i < relacaoDeFuncionarios.size(); i++) {
			totalImpostoRenda = totalImpostoRenda + relacaoDeFuncionarios.get(i).getImpostoDeRenda();
		}

		//calcula media de imposto de renda
		mediaImpostoRenda = totalImpostoRenda / relacaoDeFuncionarios.size();

		//exibe mensagem com os valores de imposto de renda
		lermsg("O valor total do IR foi de: " + String.format("%.2f", totalImpostoRenda));
		lermsg("A media de total de IR foi de: " + String.format("%.2f", mediaImpostoRenda));

	}

	public static String lerString(String mensagem) {
		System.out.print(mensagem);
		return new Scanner(System.in).next();
	}

	public static char lerChar(String mensagem) {
		System.out.print(mensagem);
		return new Scanner(System.in).next().charAt(0);

	}

	public static double lerDouble(String mensagem) {
		System.out.print(mensagem);
		return new Scanner(System.in).nextDouble();

	}

	public static int lerInt(String mensagem) {
		System.out.print(mensagem);
		return new Scanner(System.in).nextInt();

	}

	public static void lermsg(String msg) {
		System.out.print(msg);
		System.out.println();
	}
}