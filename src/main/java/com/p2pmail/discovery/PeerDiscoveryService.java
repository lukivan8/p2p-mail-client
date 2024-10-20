package com.p2pmail.discovery;

import com.p2pmail.model.Peer;

import java.net.*;
import java.util.Map;

public class PeerDiscoveryService {
    private static final int DISCOVERY_PORT = 8888;
    private final String myEmailAddress;
    private final Map<String, Peer> peerList;

    public PeerDiscoveryService(String myEmailAddress, Map<String, Peer> peerList) {
        this.myEmailAddress = myEmailAddress;
        this.peerList = peerList;
    }

    public void start() {
        startBroadcasting();
        startListening();
    }

    private void startBroadcasting() {
        new Thread(this::broadcastLoop).start();
    }

    private void startListening() {
        new Thread(this::listenLoop).start();
    }

    private void broadcastLoop() {
        try (DatagramSocket socket = new DatagramSocket()) {
            socket.setBroadcast(true);
            byte[] buffer = myEmailAddress.getBytes();

            while (!Thread.currentThread().isInterrupted()) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
                        InetAddress.getByName("255.255.255.255"), DISCOVERY_PORT);
                socket.send(packet);
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listenLoop() {
        try (DatagramSocket socket = new DatagramSocket(DISCOVERY_PORT)) {
            byte[] buffer = new byte[256];

            while (!Thread.currentThread().isInterrupted()) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String email = new String(packet.getData(), 0, packet.getLength());
                peerList.put(email, new Peer(email, packet.getAddress()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}