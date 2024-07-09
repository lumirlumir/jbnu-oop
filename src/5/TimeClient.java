import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) {
        final String host = "localhost";
        final int port = 12345;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("서버에 접속함");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.print("서버의 시간:");
            String message;
            while ((message = in.readLine()) != null) {
                System.out.print(" " + message);
                System.out.flush();
            }
            System.out.println("\n연결 종료");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
