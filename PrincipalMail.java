import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalMail {
	
	public static void main(String[] args) throws IOException {
		ArrayList<Aluno> alunos = new ArrayList<>(); //ArrayList com todos os alunos
		OperacoesCSV dadosCSV = new OperacoesCSV();  //Objeto para utilizar os metodos da classe OperacoesCSV
		CriacaoEmail criarUffMail = new CriacaoEmail(); //Objeto para utilizar os metodos da classe CriacaoEmail
		Scanner in = new Scanner(System.in); //Scanner para a leitura da matricula do usuario
		
		String matricula = ""; //Variavel para armazenar a leitura realizada da matricula do aluno
		
		alunos = dadosCSV.listaAlunos(); //Usar classe LeitorCSV e passar dados do CSV para um ArrayList.
	
		System.out.println("Digite sua matricula: ");
		matricula = in.nextLine(); //Pegar matricula para a criação do email.
		
		criarUffMail.criarEmail(matricula,alunos); //Chama metodo de criar email da classe.
	}
}