package com.p2pmail;

import com.p2pmail.discovery.PeerDiscoveryService;
import com.p2pmail.messaging.MessageService;
import com.p2pmail.model.Message;
import com.p2pmail.model.Peer;
import com.p2pmail.ui.CommandLineInterface;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class P2PMailClient {
    private final Map<String, Peer> peerList;
    private final List<Message> inbox;
    private final PeerDiscoveryService peerDiscoveryService;
    private final MessageService messageService;
    private final CommandLineInterface cli;

    public P2PMailClient(String myEmailAddress) {
        this.peerList = new ConcurrentHashMap<>();
        this.inbox = new CopyOnWriteArrayList<>();
        this.peerDiscoveryService = new PeerDiscoveryService(myEmailAddress, peerList);
        this.messageService = new MessageService(myEmailAddress, peerList, inbox);
        this.cli = new CommandLineInterface(this);
    }

    public void start() throws IOException {
        peerDiscoveryService.start();
        messageService.start();
        cli.start();
    }

    public void sendMessage(String to, String subject, String body) {
        messageService.sendMessage(to, subject, body);
    }

    public List<Message> getInbox() {
        return inbox;
    }

    public Map<String, Peer> getPeerList() {
        return peerList;
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java -jar p2pmail.jar <your-email-address>");
            return;
        }
        new P2PMailClient(args[0]).start();
    }
}