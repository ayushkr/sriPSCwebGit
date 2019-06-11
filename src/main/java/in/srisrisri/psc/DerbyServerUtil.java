/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.srisrisri.clinic;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.derby.drda.NetworkServerControl;
import org.apache.log4j.Logger;

/**
 *
 * @author akr
 */
public class DerbyServerUtil extends Thread {

    private static org.apache.log4j.Logger log = Logger.getLogger(DerbyServerUtil.class);
    final int netPort;
    NetworkServerControl server;

    public DerbyServerUtil(final int netPort) {
        this.netPort = netPort;
    }

    @Override
    public void run() {

        startNetworkServer();

    }

    public NetworkServerControl startNetworkServer() {
        try {
            log.info(
                    "Starting a Derby Network Server on "
                    + InetAddress.getLocalHost() + ":" + netPort);
        } catch (UnknownHostException ex) {
            System.out.println("" + ex.toString());
        }
        try {
            // InetAddress.getLocalHost()

            server = new NetworkServerControl(
                    InetAddress.getByName("localhost"), netPort);
//            server = new NetworkServerControl(
//                    "localhost", netPort+"");
//new PrintWriter(System.out)
            server.start(new PrintWriter(System.out));
            
        } catch (Exception ex) {
            System.out.println("uuu" + ex.toString());
        }

        
        return server;
    }

}
