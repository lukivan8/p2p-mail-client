package com.p2pmail.model;

import java.io.Serializable;

public record Message(String from, String to, String subject, String body) implements Serializable { }