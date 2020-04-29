package br.com.jpa.teste;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Conta;
import br.com.jpa.modelo.PessoaFisica;

public class MenuPrincipal {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto_jpa");
		EntityManager em = emf.createEntityManager();

		System.out.println("MenuPrincipal");
		System.out.println("Digite 1 para cadastrar um cliente.");
		System.out.println("Digite 2 para cadastrar uma conta.");
		System.out.println("Digite 3 para alterar um cliente.");
		System.out.println("Digite 4 para alterar o saldo de  uma conta.");
		System.out.println("Digite 5 para deletar um cliente.");
		System.out.println("Digite 6 para deletar uma conta.");
		System.out.println("Digite 7 para consultar um cliente.");
		System.out.println("Digite 8 para consultar uma conta.");
		System.out.println("=> ");
		Integer opcao = entrada.nextInt();
		switch (opcao) {
		case 1:
			entrada.nextLine();// Limpar buffer teclado.

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
			entrada.nextLine();// Limpar buffer teclado.

			System.out.println("Cadastro de Conta");

			System.out.println("Digite a agencia: ");
			Integer agencia = entrada.nextInt();

			System.out.println("Digite a conta: ");
			Integer conta = entrada.nextInt();

			System.out.println("Digite o saldo: ");
			entrada.nextLine();// Limpar buffer teclado.
			Double saldo = (Double) entrada.nextDouble();

			System.out.println("Digite o codigo do titular: ");
			Long titular = entrada.nextLong();
			PessoaFisica pf2 = new PessoaFisica();
			pf2.setId(titular);

			Conta c1 = new Conta();
			c1.setAgencia(agencia);
			c1.setAgencia(agencia);
			c1.setConta(conta);
			c1.setSaldo(saldo);
			c1.setPessoaFisica(pf2);

			em.getTransaction().begin();
			em.persist(c1);
			em.getTransaction().commit();
			break;
		case 3:
			System.out.println("OPCAO 3 SELECIONADA.");

			System.out.println("Alterar Cadastro de Cliente");

			System.out.println("Digite o codigo do cliente a ser alterado: ");
			Long idAlt = entrada.nextLong();

			PessoaFisica pf3 = em.find(PessoaFisica.class, idAlt);

			if (pf3 != null) {

				entrada.nextLine();// Limpar buffer teclado.
				System.out.println("Digite o nome: ");
				String nomeAlt = entrada.nextLine();

				System.out.println("Digite o endereco: ");
				String enderecoAlt = entrada.nextLine();

				System.out.println("Digite o telefone: ");
				String telefoneAlt = entrada.nextLine();

				em.getTransaction().begin();
				if (!nomeAlt.isEmpty()) {
					pf3.setNome(nomeAlt);
				}
				if (!enderecoAlt.isEmpty()) {
					pf3.setEndereco(enderecoAlt);
				}
				if (!telefoneAlt.isEmpty()) {
					pf3.setTelefone(telefoneAlt);
				}
				em.getTransaction().commit();
			} else {
				System.out.println("Cliente não encontrado!");
			}
			break;
		case 4:
			System.out.println("OPCAO 4 SELECIONADA.");

			System.out.println("Alterar Saldo de uma Conta");

			System.out.println("Digite o codigo da conta: ");
			Long idContaAlt = entrada.nextLong();

			Conta c4 = em.find(Conta.class, idContaAlt);

			if (c4 != null) {

				entrada.nextLine();// Limpar buffer teclado.
				System.out.println("Digite o novo saldo: ");
				Double saldoAlt = entrada.nextDouble();

				em.getTransaction().begin();
				if (saldoAlt != null) {
					c4.setSaldo(saldoAlt);
				}
				em.getTransaction().commit();
			} else {
				System.out.println("Conta não encontrada!");
			}			
			break;
		case 5:
			System.out.println("OPCAO 5 SELECIONADA.");

			System.out.println("Deletar um Cliente");

			System.out.println("Digite o codigo do Cliente: ");
			Long idPFexc = entrada.nextLong();

			PessoaFisica pf5 = em.find(PessoaFisica.class, idPFexc);

			if (pf5 != null) {

				em.getTransaction().begin();
				em.remove(pf5);
				em.getTransaction().commit();
			} else {
				System.out.println("Cliente não encontrado!");
			}			
			break;
		case 6:
			System.out.println("OPCAO 6 SELECIONADA.");

			System.out.println("Deletar uma Conta");

			System.out.println("Digite o codigo da Conta: ");
			Long idCexc = entrada.nextLong();

			Conta c6 = em.find(Conta.class, idCexc);

			if (c6 != null) {

				em.getTransaction().begin();
				em.remove(c6);
				em.getTransaction().commit();
			} else {
				System.out.println("Conta não encontrada!");
			}			
			break;
		case 7:
			System.out.println("OPCAO 7 SELECIONADA.");

			System.out.println("Consultar um Cliente");

			System.out.println("Digite o codigo do Cliente: ");
			Long idPFCon = entrada.nextLong();

			PessoaFisica pf7 = em.find(PessoaFisica.class, idPFCon);

			if (pf7 != null) {

				System.out.println("Nome.......:" + pf7.getNome());
				System.out.println("Endereco...:" + pf7.getEndereco());
				System.out.println("Telefone...:" + pf7.getTelefone());
				
			} else {
				System.out.println("Cliente não encontrado!");
			}			
			break;
		case 8:
			System.out.println("OPCAO 8 SELECIONADA.");

			System.out.println("Consultar uma Conta");

			System.out.println("Digite o codigo da Conta: ");
			Long idCCon = entrada.nextLong();

			Conta c8 = em.find(Conta.class, idCCon);

			if (c8 != null) {

				System.out.println("Agencia....:" + c8.getAgencia());
				System.out.println("Conta......:" + c8.getConta());
				System.out.println("Saldo......:" + c8.getSaldo());
				System.out.println("Titular....:" + c8.getPessoaFisica().getNome());
				
			} else {
				System.out.println("Conta não encontrada!");
			}			
			break;
		default:
			System.out.println("Opcao Inválida. Encerrando.");
			break;
		}

		System.out.println("Fim do programa.");

	}

}
