package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
	//colocar abrir, ler e fechar aqui
	public boolean abreArquivo(String caminho) throws RemoteException;
    String sayHello() throws RemoteException;
}
