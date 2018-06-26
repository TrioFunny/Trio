package com.triofunny.trio.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.triofunny.trio.websocket.chat.*;
import org.apache.ibatis.javassist.expr.Instanceof;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@ServerEndpoint("/chatwebsocket")
public class ChatWebSocket {
    private Session session;
    private String uid;
    private static Map<String, ChatWebSocket> OnlineUsers = new HashMap<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        String uuid = UUID.randomUUID().toString();
        OnlineUsers.put(uuid, this);
        try {
            this.session.getBasicRemote().sendText("{'common':'Login','data':{'info':'success','ssid':'" + uuid + "'}}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("new connection");
    }

    @OnClose
    public void onClose() {
        OnlineUsers.remove(uid);
        System.out.println(uid + "连接断开");
    }

    @OnMessage
    public void sendMessage(String messgae) {
        ChatTransfer transfer = JSON.parseObject(messgae, ChatTransfer.class);
        if (transfer.getCommon() == ChatCommon.Login) {
            if (transfer.getData() instanceof SocketUid) {
                SocketUid socketUid = (SocketUid) transfer.getData();
                ChatWebSocket socket = OnlineUsers.get(socketUid.getUuid());
                OnlineUsers.remove(socketUid.getUuid());
                OnlineUsers.put(socketUid.getUid(),socket);
            }
        } else if (transfer.getCommon() == ChatCommon.Message) {
            if (transfer.getData() instanceof ChatModel) {
                ChatModel chatModel = (ChatModel) transfer.getData();
                if (chatModel.getType() == ChatType.Single) {
                    try {
                        OnlineUsers.get(chatModel.getToId()).session.getBasicRemote().sendText(messgae);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (chatModel.getType() == ChatType.Mutil) {

                } else {

                }
            }
        } else {

        }


//        for (ChatWebSocket webSocket : webSockets) {    //这里是对所有的socket连接发送消息
//            System.out.println("websocket消息,广播消息:{}" + messgae);
//            try {
//                webSocket.session.getBasicRemote().sendText(messgae);
//            } catch (Exception e) {
//                System.out.println("异常:{}" + e);
//            }
//        }

    }
}

