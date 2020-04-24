import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client {
    public static void main(String args[]) {
        String machine="localhost";
        int port = 1099;
        try {
            Registry registry = LocateRegistry.getRegistry(machine, port);
            Calculator calculatorum = new Calculator();  // creating an instance of the class is enough to make the whole program to work as everything is handled through Constructor (and as it extends JPanel)

            calculatorum.calc = (OperationHandler)registry.lookup("Calculator"); // stub


            while (true) {
                if(calculatorum.calc.getReady()) {
                    calculatorum.calc.calculate();
                    calculatorum.t.setText("" + calculatorum.calc.getResult());
                    calculatorum.calc.setReady(false);
                }
                else {
                    continue;
                }
            }
        } catch(Exception e) {
            System.out.println("Client exception:" + e);
        }
    }
}
