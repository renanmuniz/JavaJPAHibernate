package br.com.jpa.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.PessoaFisica;

public class MenuPrincipal {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto_jpa");
		EntityManager em = emf.createEntityManager();
		
		
		System.out.println("MenuPrincipal");
		System.out.println("Digite 1 para cadastrar um cliente.");
		System.out.println("Digite 2 para cadastrar uma conta.");
		System.out.println("=> ");
		Integer opcao = entrada.nextInt();
		switch(opcao)
		{
		case 1:
			entrada.nextLine();//Limpar buffer teclado.
			
			System.out.println("OPCAO 1 SELECIONADA.");
		
			System.out.println("Cadastro de Cliente");
			
			System.out.println("Digite o nome: ");			
			String nome = entrada.nextLine();
			
			System.out.println("Digite o endereco: ");
			String endereco = entrada.nextLine();
			
			System.out.println("Digite o telefone: ");
			String telefone = entrada.nextLine();
			
			PessoaFisica pf = new PessoaFisica();
			pf.setNome(nome);
			pf.setEndereco(endereco);
			pf.setTelefone(telefone);
			
			em.getTransaction().begin();		
			em.persist(pf);		
			em.getTransaction().commit();
			
			break;
		case 2:
			System.out.println("OPCAO 2 SELECIONADA.");
			break;
		default:
			System.out.println("Digite somente 1 ou 2. Encerrando.");
			break;
		}
		
		System.out.println("Fim do programa.");

	}

}
