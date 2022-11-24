package example.hello;
        
import java.rmi.registry.Registry;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
        
public class Server implements Hello {
        
    public Server() {}
    
    private BufferedReader buffRead;
    private File myFile;

//implementar os métodos aqui
        
    public static void main(String args[]) {
    	ManipuladorArquivos m = new ManipuladorArquivos();
        
        try {
            Server obj = new Server();
            
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
            
            LocateRegistry.createRegistry(1099);
            // Bind the remote object's stub in the registry
            
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Hello", stub);

            System.err.println("Server ready!");
            //abreArquivo("/HelloRMI/src/example/hello/teste");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }


    public boolean abreArquivo(String caminho) {
    	myFile = new File(caminho);


		try {
			buffRead = new BufferedReader(new FileReader(myFile));
			System.out.println("Oi");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
    
    
	@Override
	public String sayHello() throws RemoteException {
		// TODO Auto-generated method stub
		return "Hello";
	}

}