package Client_Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        int portNumber = 1777;
        String str = "Тестовая строка для передачи";
        System.out.println("Client is started");
        Socket socket = new Socket("127.0.0.1", portNumber);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        pw.println(str);
            while((str = br.readLine())!= null){
                if (str.equals("bye")){
                    break;
                }
                System.out.println(str);
                pw.println("bye");
            }
            br.close();
            pw.close();
            socket.close();
    }
}
