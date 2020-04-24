import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client {
    public static void main(String args[]) {
        String machine="localhost";
        int port = 1099;
       // App calculatorum = new App();
        try {
            Registry registry = LocateRegistry.getRegistry(machine, port);
            //Ap obj = (Ap)registry.lookup("Calculator");


            App calculatorum = new App();
            calculatorum.calc = (OpHand)registry.lookup("Calculator");


//            while(!calculatorum.calc.isset()) {
//                System.out.println("salut");
//                ;
//            }
//            calculatorum.calc.calculate();
//            calculatorum.t.setText("" + calculatorum.calc.getResult());


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

            //System.out.println(obj.);
            //App app = new App();

        } catch(Exception e) {
            System.out.println("Client exception:" + e);
        }
    }
}
