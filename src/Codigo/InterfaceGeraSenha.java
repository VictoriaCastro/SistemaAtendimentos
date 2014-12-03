package Codigo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceGeraSenha extends Remote {

	public int geraSenha(String nome, String prioritario) throws RemoteException;

	public boolean verificaSenha() throws RemoteException;

	public String geraCaixa() throws RemoteException;

	public Senha chamaCliente(String nomeCaixa) throws RemoteException;

}
