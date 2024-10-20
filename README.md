# P2P Mail Client

A simple peer-to-peer mail client for local networks.

## Prerequisites

- Java Development Kit (JDK) 22 or later
- Apache Maven 3.6.0 or later

## Installing Maven

If you don't have Maven installed, please follow the instructions in our [Maven Installation Guide](MAVEN_INSTALL.md).

## Installation and Running

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/p2p-mail-client.git
   cd p2p-mail-client
   ```
2. Build the project:
   ```
   mvn clean package
   ```
3. Run the application:
   ```
   java -jar target/p2p-mail-client-1.0-SNAPSHOT.jar your.email@example.com
   ```
   Replace `your.email@example.com` with your desired email address.

## Usage

Once the application starts, you'll see a menu with the following options:
1. Send Message
2. Check Inbox
3. List Peers
4. Exit

- To send a message, choose option 1 and follow the prompts.
- To check your inbox, choose option 2.
- To see a list of discovered peers, choose option 3.

## Troubleshooting

If you're having trouble seeing other peers or sending/receiving messages:

1. Ensure all peers are on the same local network.
2. Check that your firewall is not blocking Java or the ports used (8888 for discovery, 8889 for messaging).
3. Some routers may block UDP broadcasts. Try connecting peers directly using their IP addresses.
4. If using a VPN, try disconnecting it as it might interfere with local network discovery.
5. Ensure that your network allows peer-to-peer connections.

## Known Limitations

- Works only on local networks; cannot send messages over the internet.
- No message persistence; messages are lost when the application is closed.
- Peer discovery might not work on all network configurations.
- No encryption or authentication; not suitable for sensitive information.

## Future Improvements

- Implement message persistence
- Add encryption for message security
- Improve peer discovery
- Develop a graphical user interface

## Contributing

Contributions are welcome! Please ensure you have Maven installed before contributing to this project. Feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.