package com.frank.rabbitmq;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Receiver {
	
	private final static String QUEUE_NAME = "myHello";
    public static void main(String[] argv) throws Exception {
      
    	ConnectionFactory factory = new ConnectionFactory();
    	factory.setHost("120.79.70.250");
        factory.setUsername("frank");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        
         channel.basicQos(1);//使得每个Consumer在同一个时间点最多处理一个Message。在接收到该Consumer的ack前，不会将新的Message分发给它
        
        
        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,AMQP.BasicProperties properties,byte[] body) throws IOException {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                //发生异常
                System.out.println("开始发生异常===========");
                String s = null;
                if(true){
                		s.toString();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        
        channel.basicConsume(QUEUE_NAME, false, consumer);	
        
        

    }
}
