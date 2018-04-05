package polimorfismo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import polimorfismo.EntradaTeclado;

public class Agenda {
	
	private Pessoa contato[];
	private int nPessoas;
	private int ultimoContato;
	
	public Agenda(int np){
		this.contato = new Pessoa[np];
		this.nPessoas = np;
		this.ultimoContato = 0;
	}
	
	public int menu() throws Exception {
		
		System.out.println("Escolha alguma das opções abaixo: ");
		System.out.println("---------------------------------");
		System.out.println("|1 - Adicionar um contato       |");
		System.out.println("|2 - Exibir Todos os Contatos	|");
		System.out.println("|3 - Pesquisar um Contato       |");
		System.out.println("|4 - Ordenar agenda de Contatos	|");
		System.out.println("|5 - Exit                       |");
		System.out.println("---------------------------------");
		System.out.print("Digite sua opção: ");
		int op = EntradaTeclado.leInt();
		System.out.println();

		return op;
		
	}
	
	public void add(Pessoa p) { 
		this.contato[this.ultimoContato++] = p;
	}
	
	public void addContato() throws Exception { 
		
		System.out.println("Qual o tipo do Contato vamos adicionar ?");
		System.out.println("1 - Pessoa Física");
		System.out.println("2 - Pessoa Juridica");
		System.out.print("Digite sua opção: ");
		int op = EntradaTeclado.leInt();
		System.out.println();
		System.out.print("Digite o nome do novo contato: ");
		String nome =  EntradaTeclado.leString();
		System.out.print("Digite o endereco do novo contato: ");
		String endereco =  EntradaTeclado.leString();
		System.out.print("Digite o email do novo contato: ");
		String email =  EntradaTeclado.leString();
		
		if(op == 1) {

			System.out.print("Digite o CPF do novo contato: ");
			String cpf =  EntradaTeclado.leString();
			System.out.print("Digite a data de Nascimento do novo contato: ");
			String dataNas =  EntradaTeclado.leString();
			
			PessoaFisica novoContato = new PessoaFisica(nome,endereco,email,cpf,dataNas);
			this.add(novoContato);
			
		}else{
			
			System.out.print("Digite o CNPJ do novo contato: ");
			String cnpj =  EntradaTeclado.leString();
			System.out.print("Digite a inscrição estadual: ");
			String inscEstadual =  EntradaTeclado.leString();
			System.out.print("Digite a razao social: ");
			String razaoSocial =  EntradaTeclado.leString();	
			
			PessoaJuridica novoContato = new PessoaJuridica(nome,endereco,email,inscEstadual,razaoSocial,cnpj);
			this.add(novoContato);
		}
		
		System.out.println("\nNOVO CONTATO ADICIONADO COM SUCESSO !!!\n");
		this.consulta(this.ultimoContato - 1);
		
		
	}
	
	public void consulta() {	
		for(int i = 0; i < this.ultimoContato; i++){		
			this.consulta(i);		
		}
	}
	
	
	
	public void consulta(int id){
		
		System.out.println("Contato " + (id + 1));
		System.out.println("Nome: " + this.contato[id].nome);
		System.out.println("Endereco: " + this.contato[id].endereco);
		System.out.println("Email: " + this.contato[id].email);
		
		
		if(this.contato[id] instanceof PessoaFisica)	{
			
			PessoaFisica pf = (PessoaFisica) this.contato[id];
			System.out.println("Cpf: " + pf.cpf);
			System.out.println("Data Nas: " +  pf.dataNas);
			System.out.println("Tipo Pessoa Fisica\n");
			
		}else {
			
			PessoaJuridica pj = (PessoaJuridica) this.contato[id];
			System.out.println("Cnpj: " + pj.cnpj);
			System.out.println("Razao Social: " +  pj.razaoSocial);
			System.out.println("Inscrição Estadual: " +  pj.inscEstadual);
			System.out.println("Tipo Pessoa Juridica\n");
			
		}
		
	}
	
	public void ordena() {
		
		Vector<PessoaFisica> pf = new Vector<PessoaFisica>();
		Vector<PessoaJuridica> pj = new Vector<PessoaJuridica>();
		
		for (int i = 0; i < this.ultimoContato; i++) {
			if(this.contato[i] instanceof PessoaFisica) {
				pf.add((PessoaFisica)this.contato[i]) ;
			}else {
				pj.add((PessoaJuridica)this.contato[i]) ;
			}
		} 
		
		Collections.sort(pf);
		Collections.sort(pj);
		int i;
		
		for ( i = 0; this.contato[i] instanceof PessoaFisica; i++) {
			this.contato[i] = pf.elementAt(i);
		} 
		
		for (int j = 0; i < this.ultimoContato; i++,j++) {
			this.contato[i] = pj.elementAt(j);
		} 
		 
	}
	
	public void busca() throws IOException {
		System.out.print("Digite um nome para buscar: ");
		String nome = EntradaTeclado.leString();
		
		for(int i = 0;i < this.ultimoContato;i++) {
			if(this.contato[i].nome.equals(nome)){
				consulta(i);
				return;
			}
		}
		
		System.out.println("Não existe nenhum contato cadastrado com este nome !\n");
	}
	
	public static void main(String[] args)throws Exception {
		
		int op = 0;
		
		System.out.println("Olá usuário !");
		System.out.print("Quantas pessoas tem sua agenda ? ");
		Agenda agenda = new Agenda(EntradaTeclado.leInt());

		System.out.println("\n***** AGENDA COM " + agenda.nPessoas + " CONTATO(S) CRIADA COM SUCESSO !!\n");
		
		while(op != 5){
			op = agenda.menu();	
			
			if(op == 1){
				agenda.addContato();
			}else if(op == 2){
				agenda.consulta();
			}else if(op == 3){
				agenda.busca();
			}else if(op == 4){
				agenda.ordena();
			}else if(op != 4){
				System.out.println("Opção Inválida !!! \n");
			}
			
		}


		System.out.println("//////////// FIM //////////////");
		
		
	}

}
