package com.p2pmail.messaging;

import com.p2pmail.model.Message;
import com.p2pmail.model.Peer;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;

public class MessageService {
    private static final int MESSAGE_PORT = 8889;
    private final String myEmailAddress;
    private final Map<String, Peer> peerList;
    private final List<Message> inbox;

    public MessageService(String myEmailAddress, Map<String, Peer> peerList, List<Message> inbox) {
        this.myEmailAddress = myEmailAddress;
        this.peerList = peerList;
        this.inbox = inbox;
    }

    public void start() {
        new Thread(this::listenForMessages).start();
    }

    public void sendMessage(String to, String subject, String body) {
        Peer recipient = peerList.get(to);
        if (recipient == null) {
            System.out.println("Recipient not found in the network.");
            return;
        }

        try (Socket socket = new Socket(recipient.address(), MESSAGE_PORT);
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
            Message message = new Message(myEmailAddress, to, subject, body);
            oos.writeObject(message);
            System.out.println("Message sent successfully.");
        } catch (Exception e) {
            System.out.println("Failed to send message: " + e.getMessage());
        }
    }

    private void listenForMessages() {
        try (ServerSocket serverSocket = new ServerSocket(MESSAGE_PORT)) {
            while (!Thread.currentThread().isInterrupted()) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleIncomingMessage(clientSocket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleIncomingMessage(Socket socket) {
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
            Message message = (Message) ois.readObject();
            inbox.add(message);
            System.out.println("New message received from: " + message.from());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}