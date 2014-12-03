package Codigo;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorPainel {

	public ServidorPainel() throws RemoteException {
	}

	public static void main(String[] args) {

		try {
			Registry registry = LocateRegistry.createRegistry(1357);
			registry.rebind("Atendimento", new InterfacePainelImplement());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Servidor do painel disponível!");
		
	}

}
