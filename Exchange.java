import java.io.*;
import java.util.*;
public class Exchange extends stock{
	//match orders
	Maximum max = new Maximum();
	list1 node7 = null;
	Queue sell = new Queue();
	Queue buy = new Queue();
	Queue satisfy = new Queue();				 
	public void perform()
	{	
		do{
		list1 node8 = null;
		try{
		if(node7==null)
		node7=stock.head1;
		else node7=node7.next;
	if((node7.Type).equals("sell"))
	{	if(buy.front == null)
		{	sell.Enqueue(node7);
			node7.Time=stock.getTime()+node7.T0;
			node7.Log="S";
			continue;
		}
		do{
		if(node8==null)
		node8=buy.front;
		else node8=node8.next;
		if((node8.Stock).equals((node7.Stock)))
		{									
		if((node8.Qty==node7.Qty) && stock.getTime()<(node8.T0 + node8.Texp)){
			if(max.cost < (node7.Qty)*(node8.Price-node7.Price))
			{	max.cost = (node7.Qty)*(node8.Price-node7.Price);	
				max.node = node8; 
			}	
		}
		else if((node8.Qty>node7.Qty && node8.Partial == 'T') && stock.getTime()<(node8.T0 + node8.Texp)){
			if(max.cost < (node7.Qty)*(node8.Price-node7.Price))
			{	max.cost = (node7.Qty)*(node8.Price-node7.Price);	
				max.node = node8; 
			}	
		}
		else if((node8.Qty<node7.Qty && node7.Partial == 'T') && stock.getTime()<(node8.T0 + node8.Texp)){ 
	 		if(max.cost < (node8.Qty)*(node8.Price-node7.Price))
		{	max.cost = (node8.Qty)*(node8.Price-node7.Price);	
			max.node = node8; 
		}
		}	
		}}while(node8!=buy.rear);
		if(max.node == null)
		{	sell.Enqueue(node7);
			node7.Log = "S";
			node7.Time=stock.getTime()+node7.T0;
			continue;
		}
		node8=buy.front;
		while(node8!=max.node )
		{	node8=node8.next;
			if(node8==buy.rear)
			break;
		}
		if(node8.Qty == node7.Qty && stock.getTime()<(node8.T0 + node8.Texp))
		{
			node7.Log = "T";
			node7.Qty=0;
			satisfy.Enqueue(node8); 
			node8.Qty=0;
			node8.Log = "T";
		}
		else if((node8.Qty > node7.Qty && node8.Partial == 'T') && stock.getTime()<(node8.T0 + node8.Texp))
		{
			node7.Log = "T";
			node8.Qty = node8.Qty - node7.Qty;
			node7.Qty=0;
		}
		else if((node8.Qty < node7.Qty && node7.Partial == 'T') && stock.getTime()<(node8.T0 + node8.Texp))
		{
			node8.Log = "T";
			satisfy.Enqueue(node8);
			node7.Qty = node7.Qty - node8.Qty;
			node8.Qty=0;	
			node7.Time=stock.getTime()+node7.T0;					
			sell.Enqueue(node7);
			node7.Log = "S";
		}
		else {node7.Log = "S";sell.Enqueue(node7);
		node7.Time=stock.getTime()+node7.T0;}
	}
	if((node7.Type).equals("buy"))
	{	if(sell.front == null)
		{	buy.Enqueue(node7);
			node7.Log="P";
			 node7.Time=stock.getTime()+node7.T0;
			continue;
		}
		do{
		if(node8==null)
		node8=sell.front;
		else node8=node8.next;
		if((node8.Stock).equals((node7.Stock)))
		{												
		if((node8.Qty==node7.Qty) && stock.getTime()<(node8.T0 + node8.Texp)){
			if(max.cost < (node7.Qty)*(node8.Price-node7.Price))
			{	max.cost = (node7.Qty)*(node8.Price-node7.Price);	
				max.node = node8; 
			}	
		}
		if((node8.Qty>node7.Qty && node8.Partial == 'T') && stock.getTime()<(node8.T0 + node8.Texp)){
			if(max.cost < (node7.Qty)*(node8.Price-node7.Price))
				{	max.cost = (node7.Qty)*(node8.Price-node7.Price);	
					max.node = node8;
				}	
			}
		if((node8.Qty<node7.Qty && node7.Partial == 'T') && stock.getTime()<(node8.T0 + node8.Texp)){ 
	 		if(max.cost < (node8.Qty)*(node8.Price-node7.Price))
			{	max.cost = (node8.Qty)*(node8.Price-node7.Price);	
				max.node = node8; 
			}
			}
		}
		}while(node8!=sell.rear);
		if(max.node == null)
		{	buy.Enqueue(node7);
			node7.Log = "P";
			 node7.Time=stock.getTime()+node7.T0;
			continue;
		}
		node8=sell.front;
		while(node8!=max.node)
		{	node8=node8.next;
			if(node8==sell.rear)
			break;
		}
		if((node8.Qty == node7.Qty) && stock.getTime()<(node8.T0 + node8.Texp))
		{
			node7.Log = "T";
			node8.Log = "T";
			satisfy.Enqueue(node8);
			node8.Qty=0;
			node7.Qty=0;
		}
		else if((node8.Qty > node7.Qty && node8.Partial == 'T') && stock.getTime()<(node8.T0 + node8.Texp))
		{
			node7.Log = "T";
			node8.Qty = node8.Qty - node7.Qty;
			node7.Qty=0;
		}
		else if((node8.Qty < node7.Qty && node7.Partial == 'T') && stock.getTime()<(node8.T0 + node8.Texp))
		{
			node8.Log = "T";
			satisfy.Enqueue(node8);
			node7.Qty = node7.Qty - node8.Qty; 						
			node8.Qty=0;
			buy.Enqueue(node7);
			node7.Time=stock.getTime()+node7.T0;
			node7.Log = "P";
		}
		else {node7.Log="P";buy.Enqueue(node7);
		node7.Time=stock.getTime()+node7.T0;}
		
			
	}}catch(NullPointerException e){e.printStackTrace();}
	}while(node7!=tail);
}	
	
		public void OutputExchange(){ 									
		{
		test.listb(buy,sell,satisfy);
		list1 node5 = null;
	try{	
		FileOutputStream fs = new FileOutputStream("exchange.out.txt",false);			
		PrintStream bw = new PrintStream(fs);
		
		do{
		if(node5==null)
		{node5=stock.head1;
		}else node5=node5.next;
		bw.print(node5.Log + " " +  node5.Time+ " " +node5.T0+ " " + node5.Name + " " + node5.Texp + " " + node5.Type + " " + node5.Qty + " " + node5.Stock + " " + node5.Price + " " + node5.Partial+"\n");
		
		}while(node5.next!=stock.tail);
		
	}catch(IOException e){
			e.printStackTrace();
		}
		}
}	
}
class Queue{
	list1 front = null;
	list1 rear = null;
	public void Enqueue(list1 node){
		list1 node1=new list1();
		node1.T0=node.T0;
		node1.Name=node.Name;
		node1.Texp = node.Texp ;
		node1.Type = node.Type ;
		node1.Qty = node.Qty ;
		node1.Stock = node.Stock ;
		node1.Price = node.Price ;
		node1.Partial = node.Partial ;
		node1.next = null;
		if(front==null)
		{front=node1;
		rear=front;
		}
		else 
		{	rear.next=node1;
			rear=node1;
		}	
	}
	public list1 Dequeue(){
	list1 node = front;
	front=front.next;
	return node;
	}
}
class Maximum{
	public int cost=0;
	list1 node = null;
}

		
