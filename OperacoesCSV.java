import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OperacoesCSV {
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	private String localArquivo = "..\\alunos.csv"; //Indica onde o arquivo vai estar
	
	public OperacoesCSV() { //Possibilidade de passar endereço pelo construtor
	}
	
	public ArrayList<Aluno> listaAlunos() throws IOException {
		BufferedReader conteudoCSV = null;
		String linha = ""; //Iniciando variavel que vai receber cada linha do arquivo CSV
		String csvSeparador = ","; //Delimitador de separação dos dados do arquivo
		
		try {
			conteudoCSV = new BufferedReader(new FileReader(localArquivo));
			
			linha = conteudoCSV.readLine(); //Pular a primeira linha do arquivo
			
			while((linha = conteudoCSV.readLine()) != null){ // Lendo cada linha do arquivo
				String[] dadosAluno = linha.split(csvSeparador); //Separa os dados pelo delimitador do arquivo
				Aluno aluno =  new Aluno();
				
				//Adicionando os dados do aluno de acordo com a ordem do CSV
				aluno.setNome(dadosAluno[0]);
				aluno.setMatricula(dadosAluno[1]);
				aluno.setTelefone(dadosAluno[2]);
				aluno.setEmail(dadosAluno[3]);
				aluno.setUffMail(dadosAluno[4]);
				aluno.setStatus(dadosAluno[5]);
				
				alunos.add(aluno); //Adicionando o aluno no ArrayList de alunos
			}
		}catch(FileNotFoundException e){ 
			System.out.println("Arquivo não encontrado: "+ e.getMessage());
		}finally {
			if(conteudoCSV != null) {
				try {
					conteudoCSV.close(); //Se tudo ocorreu corretamente, fechar o BufferedReader
				}catch(IOException e){
					System.out.println("IO Erro: "+ e.getMessage());
				}
			}
		}
		return alunos;
	}
	
	public void escreverCSV(ArrayList<Aluno> alunos) throws IOException {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(localArquivo));
            String linha = "";

            linha = "nome,matricula,telefone,email,uffmail,status";
            buffWrite.append(linha + "\n");

            for(int i=0;i<alunos.size();i++) {
            	buffWrite.append(alunos.get(i) + "\n");
            }
            buffWrite.close();
	}
}
