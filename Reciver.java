import java.lang.Thread;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
class Reciver extends Thread
{
Socket skt;
public Reciver(Socket skt)
{
this.skt=skt;
}
public void run()
{
try(DataInputStream dis=new DataInputStream(skt.getInputStream()))
			{
				String msg="";


			do{				
				msg=dis.readUTF();
				System.out.println(msg);
				}while(!msg.equalsIgnoreCase("bye"));
			}
								
			
			catch(Exception e)
				{
				System.out.println(e);
				}
}


}	