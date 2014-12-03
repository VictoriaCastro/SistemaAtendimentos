package Codigo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class Caixa {

	private Scanner teclado;
	private String chamar;

	public static void main(String[] args) throws RemoteException, NotBoundException {

		Caixa atende = new Caixa();
		atende.go();

	}

	public void go() throws RemoteException, NotBoundException {

		Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1557);
		InterfaceGeraSenha igs = (InterfaceGeraSenha) myRegistry.lookup("Atendimento");
		
		teclado = new Scanner(System.in);

		String caixa = igs.geraCaixa();

		System.out.println("\n *** Bem vindo ao " + caixa + " ***\n");

		while (true) {
			
			System.out.println("\n Aperte enter para chamar o próximo atendimento! ");
		    chamar = teclado.nextLine();
					
			Senha s = igs.chamaCliente(caixa);

			if (s != null) {
				System.out.println("\n Atendimento: ");
				System.out.println("\n Nome: " + s.getNome());
				System.out.println("\n Prioridade: " + s.getPrioritario());
				System.out.println("\n Senha: " + s.getSenha());

			} else {
				System.out.println("\n Não há atendimentos em espera!");
				while (true) {
					if (igs.verificaSenha()) {
						System.out.println("\n Próximo atendimento \n");
					}
				}
			}
		}
	}
}
