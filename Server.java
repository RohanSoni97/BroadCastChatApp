import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
class Server
{
public static void main(String []args)
	{
	try(ServerSocket s=new ServerSocket(12345))
		{
			System.out.print("Waiting for client request");
			ArrayList<Socket> al=new ArrayList<Socket>();
			Socket skt;
			while(true)
			{
			skt=s.accept();
			//System.out.println("Connected to Client");
			al.add(skt);
			BroadCast b=new BroadCast(al);
			b.start();
			}
		}
		catch(Exception e)
		{
				System.out.println(e);
		}
			
	}
	
}