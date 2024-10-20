# P2P Mail Client

A simple peer-to-peer mail client for local networks.

## Installation

1. Ensure you have Java Development Kit (JDK) 11 or later installed on your system.
2. Clone the repository:
   ```
   git clone https://github.com/lukivan8/p2p-mail-client.git
   cd p2p-mail-client
   ```
3. Build the project using Maven:
   ```
   mvn clean package
   ```

## Usage

1. Run the application:
   ```
   java -jar target/p2p-mail-client-1.0.jar your.email@example.com
   ```
   Replace `your.email@example.com` with your desired email address.

2. Once the application starts, you'll see a menu with the following options:
    - Send Message
    - Check Inbox
    - List Peers
    - Exit

3. To send a message, choose option 1 and follow the prompts to enter the recipient's email, subject, and message body.

4. To check your inbox, choose option 2.

5. To see a list of discovered peers, choose option 3.

## Troubleshooting

If you're having trouble seeing other peers or sending/receiving messages, try the following:

1. Ensure all peers are on the same local network.
2. Check that your firewall is not blocking Java or the ports used by the application (8888 for discovery, 8889 for messaging).
3. Some routers may block UDP broadcasts. Try connecting peers directly using their IP addresses.
4. If you're using a VPN, try disconnecting it as it might interfere with local network discovery.
5. Ensure that your network allows peer-to-peer connections.

## Known Limitations

- This client only works on local networks and cannot send messages over the internet.
- There's no message persistence. All messages are lost when the application is closed.
- The peer discovery might not work on all network configurations, especially those that restrict UDP broadcasts.
- There's no encryption or authentication, so it should not be used for sensitive information.

## Future Improvements

- Implement message persistence
- Add encryption for message security
- Improve peer discovery to work across different network configurations
- Develop a graphical user interface

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.