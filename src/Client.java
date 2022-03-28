import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static final String endpoint = "http://localhost:8080/axis/Bank.jws";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ServiceException, MalformedURLException, RemoteException {
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new URL(endpoint));
        while (true) {
            String response;
            switch (menu()) {
                case 1:
                    System.out.println("Enter account");
                    String account = scanner.nextLine();
                    response = (String) call.invoke("findSum", new Object[]{account});
                    System.out.println(response);
                    break;
                case 2:
                    System.out.println("Enter sum");
                    String sum = scanner.nextLine();
                    response = (String) call.invoke("findAccount", new Object[]{sum});
                    System.out.println(response);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    private static int menu() {
        System.out.println("1 - find sum");
        System.out.println("2 - find account");
        System.out.println("3 - exit");
        System.out.println("Your choice:");

        while (!scanner.hasNext("[123]")) {
            System.out.println("Reentr value");
            scanner.next();
        }

        int i = scanner.nextInt();
        scanner.nextLine();
        return i;
    }
}
