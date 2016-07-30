/**
 * Created by com.lei on 15-5-18.
 */
package com.lei.memory;

import java.util.ArrayList;
import java.util.List;

class OOMObject {
    public byte[] placeHolder = new byte[64 * 1024];
}

public class JConsoleExample {

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> oomObjectList = new ArrayList<OOMObject>();
        for (int i = 0; i < 100000; i++) {
            oomObjectList.add(new OOMObject());
            Thread.sleep(5);
        }
        System.gc();
    }

}
