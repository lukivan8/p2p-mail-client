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
                    System.out.println("Выходим...");
                    System.exit(0);
                default:
                    System.out.println("Неверное действие. Попробуйте снова...");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n1. Отправить Сообщение");
        System.out.println("2. Проверить Входящие");
        System.out.println("3. Список Активных пользователей");
        System.out.println("4. Выход");
        System.out.print("Выберите действие: ");
    }

    private void sendMessage() {
        System.out.print("Получатель: ");
        String to = scanner.nextLine();
        System.out.print("Тема: ");
        String subject = scanner.nextLine();
        System.out.print("Текст: ");
        String body = scanner.nextLine();
        client.sendMessage(to, subject, body);
    }

    private void checkInbox() {
        System.out.println("Входящие:");
        for (Message message : client.getInbox()) {
            System.out.println("Отправитель: " + message.from());
            System.out.println("Тема: " + message.subject());
            System.out.println("Текст: " + message.body());
            System.out.println("--------------------");
        }
    }

    private void listPeers() {
        System.out.println("Активные пользователи:");
        for (Peer peer : client.getPeerList().values()) {
            System.out.println(peer.email() + " - " + peer.address().getHostAddress());
        }
    }
}
