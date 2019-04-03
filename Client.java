import java.net.*;
import java.io.*;
class Client
{
public static void main(String []args)
	{
	try(Socket skt=new Socket("192.168.43.95",12345))
		{
			System.out.println("Connected to Server");
			Send se=new Send(skt);
			
			Reciver r=new Reciver(skt);
			se.start();
			r.start();
			se.join();
			r.join();

		}
		
		catch(Exception e)
			{
				System.out.println(e);
			}
	}
}
