import java.io.*;
public class test implements Runnable{
	public static Queue listbuy,listsell,listsatisfy;
	public static void listb(Queue node1,Queue node2,Queue node3){
	        listbuy = node1;
	        listsell = node2;
	        listsatisfy = node3;
	}
	public void run(){	
	
	try{    FileOutputStream fs1 = new FileOutputStream("cleanup.out.txt",false);			
		PrintStream bw1 = new PrintStream(fs1);
		
		while(stock.getTime()<=(stock.tail.T0 + stock.tail.Texp))
	{       try{	list1 node=null;
	        do{
	        if(listbuy.front == null)
	        break;
	        if(node==null)
		node = listbuy.front;
		else node=node.next;
		if(stock.getTime()>(node.T0+node.Texp))
		{
		        list1 node5=listbuy.Dequeue();
		        bw1.print(node5.T0+ " " + node5.Name + " " + node5.Texp + " " + node5.Type + " " + node5.Qty + " " + node5.Stock + " " + node5.Price + " " + node5.Partial+"\n");
		}
		}while(node!=listbuy.rear);
		do{
	        if(listsell.front == null)
	        break;
	        if(node==null)
		node = listsell.front;
		else node=node.next;
		if(stock.getTime()>(node.T0+node.Texp))
		{
		        list1 node5=listsell.Dequeue();
		        bw1.print(node5.T0+ " " + node5.Name + " " + node5.Texp + " " + node5.Type + " " + node5.Qty + " " + node5.Stock + " " + node5.Price + " " + node5.Partial+"\n");
		}
		}while(node!=listsell.rear);
		do{
	        if(listsatisfy.front == null)
	        break;
	        if(node==null)
		node = listsatisfy.front;
		else node=node.next;
		if(stock.getTime()>(node.T0+node.Texp))
		{
		        list1 node5=listsatisfy.Dequeue();
		        bw1.print(node5.T0+ " " + node5.Name + " " + node5.Texp + " " + node5.Type + " " + node5.Qty + " " + node5.Stock + " " + node5.Price + " " + node5.Partial+"\n");
		}
		}while(node!=listsatisfy.rear);
		}catch(Exception e){}
		
	}
	}catch(FileNotFoundException e){}
	
	}
}
