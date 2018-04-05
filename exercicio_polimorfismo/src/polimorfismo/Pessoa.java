package polimorfismo;

public class Pessoa {
	
	String nome;
	String endereco;
	String email;
	
	public int compareTo(Pessoa p) {
		if(this instanceof PessoaFisica &&  p instanceof PessoaFisica) {
			
			PessoaFisica pf = (PessoaFisica)this;
		   return pf.compareTo(p);
		   
	   }else if(this instanceof PessoaJuridica &&  p instanceof PessoaJuridica) {
		   
		   	PessoaJuridica pf = (PessoaJuridica)this;
			return pf.compareTo(p);
			
	   }else {
		   
		   if(this instanceof PessoaFisica) {
			   return -1;
		   }else {
			   return 1;
		   }
	   
	   }
	}	
	
	public Pessoa(String nome,String endereco,String email){
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
	}
}
