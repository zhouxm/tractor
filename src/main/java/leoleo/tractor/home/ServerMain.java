package leoleo.tractor.home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import leoleo.tractor.server.Server;
import leoleo.tractor.view.NullView;

public class ServerMain {
    public static void main(String... args) throws Exception {
        /* Find external IP */
        String IP = new BufferedReader(new InputStreamReader(new URL(
                "http://icanhazip.com/").openStream())).readLine();
        System.out.println("Your IP is " + IP + ".");

        new Server(new NullView("[cn.jj.ai.tractor.server]")).startServer(3003);
    }
}
