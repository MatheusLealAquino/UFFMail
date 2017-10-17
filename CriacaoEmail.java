import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CriacaoEmail {
	 	private String dominio = "@id.uff.br"; //dominio da UFF
	 	
	 	public CriacaoEmail() { 
	 	}
	 	
	 	public void criarEmail(String matricula, ArrayList<Aluno> alunos) throws IOException { 
	 		boolean achou = false,ativo=false,uffMail=false; //flags para checar usuario
	 		int pos=0; //variavel para guardar posicao do aluno no array
	 		
	 		for(int i=0;i<alunos.size();i++) { //Procurando aluno que possui mesma matricula digitada
	 			if(alunos.get(i).getMatricula().equals(matricula)) { //checando se matricula digitada esta na lista de alunos 
	 				pos = i; //posicao do aluno no array
	 				achou = true;
	 				if(alunos.get(i).getStatus().equals("Ativo")) { //checar se aluno esta Ativo
	 					ativo = true;
	 				}
	 				if(alunos.get(i).getUffMail().equals("")) { //checar se aluno já não possui UFFMail
	 					uffMail = true;
	 				}
	 			}	
	 		}if(!achou) {
	 			System.out.println("Aluno(a) com matricula "+matricula+" não encontrado.\n");
	 		}else if(!ativo) {
	 			System.out.println("Aluno(a) com matricula "+matricula+" se encontra inativo.\n");
	 		}else if(!uffMail) {
	 			System.out.println("Aluno(a) com matricula "+matricula+" já possui UFFMail.\n");
	 			
	 		}else { //caso aluno tenha os requisitos, criar UFFMail
	 			
	 			int escolha=-1; //Variavel iniciada com -1 para entrar no loop que checa se valor esta dentro do range de opções 
	 			ArrayList<String> emails = new ArrayList<>(); //Variavel que guarda possibilidades de email geradas
	 			Scanner in = new Scanner(System.in); 
	 			EnvioSMS envioSMS = new EnvioSMS(); //Variavel para utilizacao da classe EnvioSMS
	 			OperacoesCSV dadosCSV = new OperacoesCSV();
	 			
	 			emails = possibilidadeEmail(alunos.get(pos)); //ArayList de e-mails recebe as possibilidades de e-mails geradas
	 			
	 			while(escolha < 0 | escolha >= emails.size()) { //Se aluno digitar um escolha fora do range de opções repete a pergunta
	 				String[] nomeCompleto = alunos.get(pos).getNome().split(" "); //Dividindo o nome para poder pegar o primeiro nome do aluno
	 				System.out.println("\n"+nomeCompleto[0]+", por favor escolha uma das opções abaixo para seu UFFMail");
	 				imprimirEmails(emails);
	 				
	 				System.out.println();
		 			escolha = in.nextInt();
		 			escolha--;
	 			}
	 			
	 			alunos.get(pos).setUffMail(emails.get(escolha));
	 			System.out.println("\nA criação de seu e-mail ("+alunos.get(pos).getUffMail()+") será feita nos próximos minutos.");
	 			System.out.println(envioSMS.enviarSMS(alunos.get(pos))); //Enviando SMS para o aluno que criou seu UFFMail
	 			
	 			dadosCSV.escreverCSV(alunos); //Chama função de atualizar CSV se e-mail foi criado com sucesso
	 		}
	 	}
	 	
	 	private void imprimirEmails(ArrayList<String> emails) { //Metodo para imprimir os email gerados
	 		for(int i=0; i<emails.size();i++) {
 				System.out.println((i+1)+" - "+emails.get(i));
 			}
	 	}
	 	
	 	private ArrayList<String> possibilidadeEmail(Aluno aluno) { //Funcao que gera as sugestoes de UFFMail
	 		ArrayList<String> possibilidades = new ArrayList<>();
	 		
	 		String[] nomeCompleto = aluno.getNome().toLowerCase().split(" ");
	 		
	 		for(int i=1;i<nomeCompleto.length;i++) {
	 			possibilidades.add(nomeCompleto[0]+nomeCompleto[i]+dominio);
	 			possibilidades.add(nomeCompleto[0].charAt(0)+nomeCompleto[i]+dominio);
	 			possibilidades.add(nomeCompleto[0]+"_"+nomeCompleto[i]+dominio);
	 		}
	 		return possibilidades;
	 	}
}