package com.kronosad.projects.kronoskonverse.server;

import com.kronosad.projects.kronoskonverse.common.objects.Version;
import com.kronosad.projects.kronoskonverse.server.implementation.NetworkUser;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * User: russjr08
 * Date: 1/17/14
 * Time: 5:30 PM
 */
public class Server {
    private int port;

    private ServerSocket server;
    private Version version = new Version().setProtocol("1.0-ALPHA").setReadable("1.0 Alpha");

    protected ArrayList<NetworkUser> users = new ArrayList<NetworkUser>();



    public Server(int port){
        this.port = port;

        System.out.println("Opening server on port: " + port);

        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("There was a problem binding to port: " + port);
        }finally {
            System.out.println("Sucessfully bounded to port!");
            serve();
        }
    }

    public void serve(){
        while (true){
            try {
                new ConnectionHandler(this, server.accept());
            } catch (IOException e) {
                System.err.println("Error accepting connection!");
                e.printStackTrace();
            }
        }
    }

    public Version getVersion() {
        return version;
    }

    public static void main(String[] args){
        new Server(Integer.valueOf(args[0]));
    }

}
