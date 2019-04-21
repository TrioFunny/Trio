package com.triofunny.trio.websocket.chat;

public class ChatTransfer {
    private ChatCommon common;
    private Object Data;
    private ChatType chatType;

    public ChatType getChatType() {
        return chatType;
    }

    public void setChatType(ChatType chatType) {
        this.chatType = chatType;
    }

    public ChatCommon getCommon() {
        return common;
    }

    public void setCommon(ChatCommon common) {
        this.common = common;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }
}
