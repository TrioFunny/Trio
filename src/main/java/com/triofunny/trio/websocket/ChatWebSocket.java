package com.triofunny.trio.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@ServerEndpoint("/chatwebsocket")
public class ChatWebSocket {
    private Session session;

    private static CopyOnWriteArrayList<ChatWebSocket> webSockets = new CopyOnWriteArrayList<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        System.out.println("new connection");
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        System.out.println("连接断开，当前总数:{}" + webSockets.size());
    }

    public void onMessage(String message) {
        System.out.println("收到客户端发来的消息:{}" + message);
    }

    @OnMessage
    public void sendMessage(String messgae) {
        for (ChatWebSocket webSocket : webSockets) {    //这里是对所有的socket连接发送消息
            System.out.println("websocket消息,广播消息:{}" + messgae);
            try {
                webSocket.session.getBasicRemote().sendText(messgae);
            } catch (Exception e) {
                System.out.println("异常:{}" + e);
            }

        }
    }
}

