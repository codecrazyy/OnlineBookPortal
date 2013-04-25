
import java.rmi.*;
import java.util.List;


public interface ServerInterface extends Remote {
    public List getdetails(String category ) throws RemoteException;
public String greetings( ) throws RemoteException;
   public void updadb(String num, int tno) throws RemoteException;
    
}
