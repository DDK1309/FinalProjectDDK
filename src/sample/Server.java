package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try (ServerSocket server = new ServerSocket(8000)) {
                    System.out.printf("Server Started!");
                    while (true) {
                        try (
                                Socket socket = server.accept();
                                BufferedWriter writer =
                                        new BufferedWriter(
                                                new OutputStreamWriter(
                                                        socket.getOutputStream()));
                                BufferedReader reader =
                                        new BufferedReader(
                                                new InputStreamReader(
                                                        socket.getInputStream()));
                        ) {
                            String request = reader.readLine();
                            System.out.println("Card information:" + request);
                            String response = "Successfully accepted to server";
                            System.out.println(response);
                            writer.write(response);
                            writer.newLine();
                            writer.flush();
                        }catch (IOException e){
                            throw new RuntimeException(e);
                        }
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();


    }


}
