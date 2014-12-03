package Codigo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class InterfaceImplement extends UnicastRemoteObject implements
		InterfaceGeraSenha {

	private static final long serialVersionUID = 1L;

	public ArrayList<Senha> senhaGeral = new ArrayList<Senha>();
	public ArrayList<Senha> senhaPrioritaria = new ArrayList<Senha>();

	public int cont = 0;
	public String nome;
	public int idCaixa = 1;
	InterfacePainel inp;

	public InterfaceImplement() throws RemoteException, NotBoundException {

		Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1357);

		inp = (InterfacePainel) myRegistry.lookup("Atendimento");
	}

	public int geraSenha(String nome, String prioritario)
			throws RemoteException {

		Senha s = new Senha(nome, prioritario);

		if (prioritario.equalsIgnoreCase("Sim")) {
			cont++;
			s.setSenha(cont);
			senhaPrioritaria.add(s);

		} else {
			if (prioritario.equalsIgnoreCase("Não")) {
				cont++;
				s.setSenha(cont);
				senhaGeral.add(s);
			}
		}
		return cont;
	}

	public boolean verificaSenha() throws RemoteException {
		if (!senhaPrioritaria.isEmpty() || !senhaGeral.isEmpty()) {
			return true;
		}
		return false;
	}

	public String geraCaixa() throws RemoteException {
		nome = " Caixa " + idCaixa;
		idCaixa += 1;

		return nome;
	}

	public Senha chamaCliente(String nomeCaixa) throws RemoteException {
		Senha s = null;

		if (senhaPrioritaria.isEmpty()) {
			if (senhaGeral.isEmpty()) {
				return null;
			}

			s = senhaGeral.get(0);
			inp.exibeAtendimento(s, nome);
			senhaGeral.remove(0);

		} else {
			s = senhaPrioritaria.get(0);
			inp.exibeAtendimento(s, nome);
			senhaPrioritaria.remove(0);

		}
		return s;
	}

}
