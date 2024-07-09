import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) {
        final int port = 12345;
        final int duration = 10000; // 10 seconds

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("타임서버");

            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("연결완료");
                OutputStream out = clientSocket.getOutputStream();

                long startTime = System.currentTimeMillis();
                int counter = 0;

                System.out.println("500ms마다 수를 보냄");
                while (System.currentTimeMillis() - startTime < duration) {
                    out.write((counter + "\n").getBytes());
                    out.flush();
                    counter++;
                    Thread.sleep(500); // 500ms delay
                }

                System.out.println("연결종료");
                
                clientSocket.close();
                serverSocket.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
