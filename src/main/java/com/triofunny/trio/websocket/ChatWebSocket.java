package com.triofunny.trio.websocket;

import com.alibaba.fastjson.JSON;
import com.triofunny.trio.websocket.chat.*;
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
            this.session.getBasicRemote().sendText("{\"common\":\"Login\",\"data\":{\"info\":\"success\",\"ssid\":\"" + uuid + "\"}}");
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
    public void sendMessage(String messgae) throws IOException {
        ChatTransfer transfer = JSON.parseObject(messgae, ChatTransfer.class);
        if (transfer.getCommon() == ChatCommon.Login) {
            SocketUid socketUid = JSON.parseObject(transfer.getData().toString(),SocketUid.class);
            if (socketUid!=null) {
                ChatWebSocket socket = OnlineUsers.get(socketUid.getUuid());
                OnlineUsers.remove(socketUid.getUuid());
                OnlineUsers.put(socketUid.getUid(),socket);
            }
        } else if (transfer.getCommon() == ChatCommon.Message) {
            if (transfer.getChatType() == ChatType.Single){
                //私聊
                SingleChat singleChat = JSON.parseObject(transfer.getData().toString(),SingleChat.class);
                ChatWebSocket ToClient = OnlineUsers.get(singleChat.getToId());
                if (null != ToClient){
                    ToClient.session.getBasicRemote().sendText(messgae);
                }else {
                    //添加入缓存
                }
            }else if(transfer.getChatType() == ChatType.Mutil){
                //群发
                MutileChat mutileChat = JSON.parseObject(transfer.getData().toString(),MutileChat.class);

            }
            else {
                this.session.getBasicRemote().sendText("error Message");
            }
        } else {

        }

    }
}

