public class Aluno {
	private String nome;
	private String matricula;
	private String telefone;
	private String email;
	private String uffMail;
	private String status;
	
	public Aluno() {
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUffMail() {
		return this.uffMail;
	}
	
	public void setUffMail(String uffMail) {
		this.uffMail = uffMail;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString() {
		return this.nome +","+this.matricula+","+this.telefone+","+this.email+","+this.uffMail+","+this.status; 
	}
}