package filehandling;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FHDemo {
	

String readData()
{
	String data="";
	try(FileReader fr=new FileReader("D:\\core java\\input.csv"))
	{
		int x;
		
		while((x=fr.read())!=-1)
		{
	   System.out.print((char)x);
	   
	    data=data+(char)x;
	   
		}
	
		
	}
	catch(IOException e)
	{
		System.out.println(e);
	}
	return data;
}
void writeData(String data)
{
	try(FileWriter fw=new FileWriter("D:\\core java\\output.csv");BufferedWriter bw=new BufferedWriter(fw);)
	{
		
		String s1=data;
		String s[]=s1.split(",");
		int price=Integer.parseInt(s[2]);
		String country=s[3];
		int st=0;
		if(country.equalsIgnoreCase("india"))
		{
			st=(price*5/100);
		}
		int fprice=st+price;
		String output=s1+","+st+","+fprice;
		bw.write(output);
		bw.flush();
		System.out.print("\noutput="+output);
	}
		
	
	catch(IOException e)
	{
	
		System.out.println(e);
	}
}
	
	
		
public static void main(String[] args) {
	FHDemo fh=new FHDemo();
	String data=fh.readData();
	fh.writeData(data);
	
}
}

