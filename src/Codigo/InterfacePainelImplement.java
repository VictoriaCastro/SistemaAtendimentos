package Codigo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InterfacePainelImplement extends UnicastRemoteObject implements
		InterfacePainel {

	protected InterfacePainelImplement() throws RemoteException {
	}

	private static final long serialVersionUID = -2575832295910460041L;

	public void exibeAtendimento(Senha senha, String caixa)
			throws RemoteException {

		System.out.println("\n\n *** Painel de Atendimentos ***");

		System.out.println("\n ** Atendimento " + caixa + " ** ");
		System.out.println("\n Nome: " + senha.getNome());
		System.out.println("\n Prioridade: " + senha.getPrioritario());
		System.out.println("\n Senha: " + senha.getSenha());
		
	}

}
