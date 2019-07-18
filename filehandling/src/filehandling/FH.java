package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FH {
public static void main(String args[])
{
	String data="";
	try(FileReader fr=new FileReader("D:\\core java\\input.csv");
			BufferedReader br=new BufferedReader(fr);)
	{
		int x;
		while((x=br.read())!=-1)
		{
			System.out.print((char)x);
			data=data+(char)x;
			
		}
		
		
	}
	catch(IOException e)
	{
		System.out.println(e);
		
	}
	try(FileWriter fw=new FileWriter("D:\\core java\\outputs.csv");
			BufferedWriter bw=new BufferedWriter(fw);)
	{
		String s[]=data.split(",");
		int price=Integer.parseInt(s[2]);
		String country=s[3];
		int st=0;
		if(country.equalsIgnoreCase("india"))
		{
			st=(price*5/100);
		}
		int fprice=st+price;
		String output=data+","+st+","+fprice;
		bw.write(output);
		bw.flush();
		System.out.println("\n"+output);
		
	}
	catch(IOException e)
	{
		System.out.println(e);
		
	}
}
}
