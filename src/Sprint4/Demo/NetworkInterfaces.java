package Sprint4.Demo;

import java.io.IOException;
import java.net.*;

public class NetworkInterfaces {

    public void multicastSocket() throws IOException {
        String ip = "234.235.236.237";
        InetAddress iadr = InetAddress.getByName(ip);
        int port = 12540;
        InetSocketAddress group = new InetSocketAddress(iadr, port);
        NetworkInterface netIf = NetworkInterface.getByName("wlan1");
        MulticastSocket socket = new MulticastSocket(port);
        socket.joinGroup(group, netIf);

    }
}
