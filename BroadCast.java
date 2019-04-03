import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
class BroadCast extends Thread
{
Socket skt;
ArrayList<Socket> al;//new ArrayList<Socket>();
public BroadCast(ArrayList<Socket> al)
{
this.al=al;
}
public void run()
{
skt=al.get(al.size()-1);
try(DataInputStream dis=new DataInputStream(skt.getInputStream()))
			{
				String msg="";


			do{				
				msg=dis.readUTF();
					for(Socket s:al){
					DataOutputStream dos=new DataOutputStream(s.getOutputStream());
					dos.writeUTF(msg);
					}
						
					
				}while(!msg.equalsIgnoreCase("bye"));
				
			}
				catch(Exception e)
				{
				System.out.println(e);
				}
}
}