
package Codigo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfacePainel extends Remote {

	public void exibeAtendimento(Senha senha, String caixa)
			throws RemoteException;

}
