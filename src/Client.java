import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client {
    public static void main(String args[]) {
        String machine="localhost";
        int port = 1099;
        try {
            Registry registry = LocateRegistry.getRegistry(machine, port);
            Ap obj = (Ap)registry.lookup("Calculator");
            //System.out.println(obj.);
            //App app = new App();

        } catch(Exception e) {
            System.out.println("Client exception:" + e);
        }
    }
}
