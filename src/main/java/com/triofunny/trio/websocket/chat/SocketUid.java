package com.triofunny.trio.websocket.chat;

import java.io.Serializable;

public class SocketUid implements Serializable {
    private String uid;
    private String uuid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
