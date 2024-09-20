package com.example.demo;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class SocketIOClient {
    public static void main(String[] args) {
        try {
            Socket socket = IO.socket("http://localhost:3000");
            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Conectado ao servidor");
                    socket.emit("message", "Olá, servidor!");
                }
            }).on("message", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Mensagem do servidor: " + args[0]);
                }
            });
            socket.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
