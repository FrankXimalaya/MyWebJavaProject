package com.frank.thread;

public class SellTicket {  
	  
    /**  
    * @param args  
    */    
   public static void main(String[] args) {    
       Ticket t = new Ticket();    
       new Thread(t).start();    
       new Thread(t).start();    
   }    
}  
class Ticket implements Runnable{    
       
   private int ticket = 10;    
   public void run() {    
       while(ticket>0){    
           ticket--;    
           System.out.println("当前票数为："+ticket);    
       }    
           
   }    
   
} 