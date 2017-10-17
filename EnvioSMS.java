public class EnvioSMS {
	
	public EnvioSMS() {
	}
	
	public String enviarSMS(Aluno aluno) {
		return "Um SMS foi enviado para "+aluno.getTelefone()+" com a sua senha de acesso.";
	}	
}
