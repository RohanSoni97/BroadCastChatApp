import java.lang.Thread;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;


class Send extends Thread
{
Socket skt;
SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MMM_dd");
Date dt=new Date();
public Send(Socket skt)
{
this.skt=skt;
}
public void run()
{String str=sdf.format(dt);
try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in));DataOutputStream dos=new DataOutputStream(skt.getOutputStream());FileWriter fr=new FileWriter(str+".txt",true))
		{		
			String msg="";
			
			do{
			msg=br.readLine();
			dos.writeUTF(msg);
			Date dt2=new Date();
			fr.write(":"+"("+dt2.getHours()+":"+dt2.getMinutes()+":"+dt2.getSeconds()+")"+msg+"\n");
			}while(!msg.equalsIgnoreCase("bye"));
		}		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
			
}
