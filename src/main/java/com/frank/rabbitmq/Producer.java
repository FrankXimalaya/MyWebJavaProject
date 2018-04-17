package com.frank.rabbitmq;

import java.io.IOException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

public class Producer {
	
	public static void main(String[] args) throws IOException, TimeoutException, java.util.concurrent.TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("frank");
        factory.setPassword("123456");
        //设置 RabbitMQ 地址
        factory.setHost("120.79.70.250");
        //建立到代理服务器到连接
        Connection conn = factory.newConnection();
        //获得信道
        com.rabbitmq.client.Channel channel = conn.createChannel();
        //声明交换器
        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName, "direct", true);

        String routingKey = "hola";
        //发布消息
        byte[] messageBodyBytes = "quit".getBytes();
        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);

        channel.close();
        conn.close();
    }

}
