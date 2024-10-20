package com.p2pmail.model;

import java.net.InetAddress;

public record Peer(String email, InetAddress address) {
}