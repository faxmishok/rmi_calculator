
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OperationHandler extends Remote {


    public double calculate() throws RemoteException;
    public double calculate(double x, double y, int num) throws RemoteException;
    public double getX() throws RemoteException;
    public double getY() throws RemoteException;
    public double getOpNum() throws RemoteException;
    public double getResult() throws RemoteException;
    public boolean isset() throws RemoteException;
    public void setX(double opX) throws RemoteException;
    public void setY(double opY) throws RemoteException;
    public void setResult(double result) throws RemoteException;
    public void setOpNumber(int opNumber) throws RemoteException;
    public boolean getReady() throws RemoteException;
    public void setReady(boolean ready) throws RemoteException;

}