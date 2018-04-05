package polimorfismo;

public class PessoaFisica extends Pessoa implements Comparable<PessoaFisica>{
	
	String cpf;
	String dataNas;
	
	public PessoaFisica(String nome,String endereco,String email,String cpf, String dataNas){
		super(nome,endereco,email);
		this.cpf = cpf;
		this.dataNas = dataNas;
	}
	
	public int compareTo(PessoaFisica p) {
		   return this.cpf.compareToIgnoreCase(p.cpf);
	}
		

}
