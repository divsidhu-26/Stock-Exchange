import java.io.*;
import java.util.*;
public class stock{
	//Perform I/O operation

		public String actionString;
		public static list1 head1=null;
		public static list1 tail=null;
		list1 node;
		static long starttime;
		public void performaction(){
		starttime=System.currentTimeMillis()/1000;
		try{
		BufferedReader br = new BufferedReader(new FileReader("input3.txt"));
		try{
		while ((actionString = br.readLine()) != null) {
				boolean valueset = false;
				node = new list1();
				try{StringTokenizer st = new StringTokenizer(actionString,"	");
				try{node.T0 = Integer.parseInt(st.nextToken());
				}catch(NumberFormatException e) {System.err.println(e);continue;}
				node.Name = st.nextToken();
				try{node.Texp = Integer.parseInt(st.nextToken());
				}catch(NumberFormatException e) {System.err.println(e);continue;}
				node.Type = st.nextToken();
				try{node.Qty  = Integer.parseInt(st.nextToken());
				}catch(NumberFormatException e) {System.err.println(e);continue;}
				node.Stock = st.nextToken();
				try{node.Price = Integer.parseInt(st.nextToken());
				}catch(NumberFormatException e) {System.err.println(e);continue;}
				node.Partial = st.nextToken().charAt(0);
				} catch(NoSuchElementException e)
				{	System.err.println(e);
					continue;
				}
				if(head1 == null)
				{head1=node;
				tail=node;
				node.Time=getTime()+node.T0;
				}
				else {	tail.next=node;
					node.Time=getTime()+node.T0;
					tail=node;
					valueset= true;
				}
		}
		}catch(IOException e){
			System.err.println(e);;
		}
			try{
				if(br != null)
				br.close();
			}catch(IOException e){
				System.err.println(e);;
			}
		}catch(FileNotFoundException e){
			System.err.println(e);;
		}
		}
		public void OutputOrder(){
		list1 node5 = new list1();
		node5=head1;								
	try{	
		FileOutputStream fs = new FileOutputStream("order.out.txt",false);			
		PrintStream bw = new PrintStream(fs);
		node5=head1;
		bw.print(node5.Time+ " " +node5.T0+ " " + node5.Name + " " + node5.Texp + " " + node5.Type + " " + node5.Qty + " " + node5.Stock + " " + node5.Price + " " + node5.Partial+"\n");
		do{
		node5=node5.next;
		bw.print(node5.Time+ " " +node5.T0+ " " + node5.Name + " " + node5.Texp + " " + node5.Type + " " + node5.Qty + " " + node5.Stock + " " + node5.Price + " " + node5.Partial+"\n");
		}while(node5!=tail);
		}catch(IOException e){
			System.err.println(e);
		}
		}
		public static double getTime(){
		return (double)(System.currentTimeMillis()/1000-starttime);
		}
}

class list1{
	public String Log;
	public double Time=0;
	public int T0;
	public String Name;
	public int Texp;
	public String Type;
	public int Qty;
	public String Stock;  
	public int Price;
	public char Partial;
	public list1 next;
	
}
	
	
	




