package Client_Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        int port = 1777;
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            while (true){
                System.out.println("Waiting for a connection on " + port);
                Socket fromClientSocket = serverSocket.accept();
                try {
                    Socket localSocket = fromClientSocket;
                    PrintWriter pw = new PrintWriter(localSocket.getOutputStream(), true);
                    BufferedReader br = new BufferedReader(new InputStreamReader(localSocket.getInputStream()));
                    String str;
                    while ((str = br.readLine()) != null){
                        System.out.println("The message: " + str);
                        if (str.equals("bye")){
                            pw.print("bye");
                            break;
                        } else {
                            str = "Server returns: " + str;
                            pw.println(str);
                        }
                    }
                    pw.close();
                    br.close();
                    localSocket.close();
                }catch (IOException e){
                    e.printStackTrace(System.out);}
            }

        } catch (IOException e){
            e.printStackTrace(System.out);
        }
    }
}
