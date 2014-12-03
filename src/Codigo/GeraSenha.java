package Codigo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class GeraSenha {

	private Scanner teclado;

	public static void main(String[] args) throws RemoteException,
			NotBoundException {

		GeraSenha novaSenha = new GeraSenha();
		novaSenha.go();

	}

	public void go() throws RemoteException, NotBoundException {

		Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1557);

		InterfaceGeraSenha igs = (InterfaceGeraSenha) myRegistry.lookup("Atendimento");

		teclado = new Scanner(System.in);

		while (true) {
			System.out.println("\n *** Gerar Senha para Atendimento ***\n");

			System.out.println("\n 1- Informe o seu nome: ");
			String nome = teclado.nextLine();

			System.out.println("\n 2- É atendimento prioritário? (Digite 'Sim' ou 'Não')");
			String prioritario = teclado.nextLine();

			int senha = igs.geraSenha(nome, prioritario);

			System.out.println("\n ** Senha gerada: " + senha + " **\n\n");

		}
	}

}
