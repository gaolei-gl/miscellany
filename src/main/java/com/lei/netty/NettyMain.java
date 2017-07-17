package com.lei.netty;

/**
 * Created by Lei on 2017/7/17.
 */
public class NettyMain {

    public static void main(String[] args) throws InterruptedException {
        DiscardServer server = new DiscardServer(9090);
        server.run();
    }
}
