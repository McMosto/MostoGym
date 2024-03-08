package com.example.loginorsignup;

import java.io.IOException;
import java.net.Socket;

public class SocketManager {
    private static final String SERVER_ADDRESS = "10.0.2.2";
    private static final int SERVER_PORT = 37261;

    private static Socket socketInstance;

    private SocketManager() {
        // Private constructor to prevent instantiation
    }

    public static synchronized Socket getSocketInstance() {
        if (socketInstance == null || socketInstance.isClosed()) {
            try {
                // Create a new socket instance if it's not available or closed
                socketInstance = new Socket(SERVER_ADDRESS, SERVER_PORT);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception appropriately (e.g., log it, show a message)
            }
        }

        return socketInstance;
    }

    public static synchronized void closeSocket() {
        if (socketInstance != null && !socketInstance.isClosed()) {
            try {
                socketInstance.close();
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception appropriately (e.g., log it, show a message)
            } finally {
                socketInstance = null;
            }
        }
    }
}
