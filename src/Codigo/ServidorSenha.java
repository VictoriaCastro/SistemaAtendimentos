package Codigo;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorSenha {

	public ServidorSenha() throws RemoteException {
	}

	public static void main(String[] args) {

		try {
			Registry registry = LocateRegistry.createRegistry(1557);
			registry.rebind("Atendimento", new InterfaceImplement());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Servidor de senha disponível!");

	}

}
