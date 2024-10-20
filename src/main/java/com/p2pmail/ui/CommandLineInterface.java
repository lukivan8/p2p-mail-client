package com.p2pmail.ui;

import com.p2pmail.P2PMailClient;
import com.p2pmail.model.Message;
import com.p2pmail.model.Peer;

import java.util.Scanner;

public class CommandLineInterface {
    private final P2PMailClient client;
    private final Scanner scanner;

    public CommandLineInterface(P2PMailClient client) {
        this.client = client;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    sendMessage();
                    break;
                case 2:
                    checkInbox();
                    break;
                case 3:
                    listPeers();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n1. Send Message");
        System.out.println("2. Check Inbox");
        System.out.println("3. List Peers");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private void sendMessage() {
        System.out.print("To: ");
        String to = scanner.nextLine();
        System.out.print("Subject: ");
        String subject = scanner.nextLine();
        System.out.print("Body: ");
        String body = scanner.nextLine();
        client.sendMessage(to, subject, body);
    }

    private void checkInbox() {
        System.out.println("Inbox:");
        for (Message message : client.getInbox()) {
            System.out.println("From: " + message.from());
            System.out.println("Subject: " + message.subject());
            System.out.println("Body: " + message.body());
            System.out.println("--------------------");
        }
    }

    private void listPeers() {
        System.out.println("Peers:");
        for (Peer peer : client.getPeerList().values()) {
            System.out.println(peer.email() + " - " + peer.address().getHostAddress());
        }
    }
}
