import java.io.*;
class checker{
	public static void main(String args[]){
		Order x = new Order();
		Thread o1 = new Thread(x);
		ExchangeThread et1 = new ExchangeThread();
		o1.start();
		et1.start();
		test thread =new test();
		Thread t1 = new Thread(thread);
		t1.start();
		try{
		        o1.join();
		        et1.join();
		        t1.join();
		}catch(InterruptedException e){System.out.println(e);}
	}
	
}
class Order implements Runnable {
	
	public void run(){
		stock ver1 = new stock();
		ver1.performaction();
		ver1.OutputOrder();	
	}
	}

class ExchangeThread extends Thread{
	
	public void run(){
		try{
		Thread.sleep(20);
		}catch(InterruptedException e){}
		Exchange e1 = new Exchange();
		e1.perform();
		try{
		Thread.sleep(20);
		}catch(InterruptedException e){}
		e1.OutputExchange();
		
	}
}
