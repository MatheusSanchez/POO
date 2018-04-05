package polimorfismo;

public class PessoaJuridica extends Pessoa implements Comparable<PessoaJuridica>{
	
	String cnpj;
	String inscEstadual;
	String razaoSocial;
	
	public PessoaJuridica(String nome,String endereco,String email,String inscEstadual, String razaoSocial,String cnpj){
		super(nome,endereco,email);
		this.cnpj = cnpj;
		this.inscEstadual = inscEstadual;
		this.razaoSocial = razaoSocial;
	}
	
	public int compareTo(PessoaJuridica p) {
		   return this.cnpj.compareToIgnoreCase(p.cnpj);
	}
	
}



