import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class Server {
    public static void main(String args[]) {
        int port = 1099;
        if(args.length==1)
            port = Integer.parseInt(args[0]);
        try {
            OperationHandler skeleton = (OperationHandler) UnicastRemoteObject.exportObject(new OperationHandlerImplementation(),0);
            Registry registry = LocateRegistry.getRegistry(port);
            if(!Arrays.asList(registry.list()).contains("Calculator"))
                registry.bind("Calculator", skeleton);
            else
                registry.rebind("Calculator", skeleton);
             System.out.println("Server is Ready!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
