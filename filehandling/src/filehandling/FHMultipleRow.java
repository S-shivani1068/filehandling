package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FHMultipleRow {
	
	void readData(String data)
	{
	try(FileReader fr=new FileReader("D:\\core java\\inputs.csv");
			BufferedReader br= new BufferedReader(fr);)
	{
		String line=br.readLine();
		
			while(line!=null)
			{
				System.out.println(line);
				String s[]=line.split(",");
				writeData(s,data,line);
				line=br.readLine();
			}
		
	}

	catch(IOException e)
	{
		System.out.println(e);
	}
	}	
	void writeData(String s[],String data,String line)
	{
	try(FileWriter fw=new FileWriter("D:\\core java\\outputm.csv",true);
			BufferedWriter bw= new BufferedWriter(fw);)
	{
	
	 int price=Integer.parseInt(s[2]);
	 String country=s[3];
	 int st=0;
	 if(country.equalsIgnoreCase("india"))
	 {
		 st=price*10/100;
	 }
	 else if(country.equalsIgnoreCase("japan"))
	 {
		 st=price*10/100;
	 }
      int fprice=price+st;
	 
     data=line+","+st+","+fprice+"\n";
     
     bw.write(data);
     bw.write(System.lineSeparator());
	  bw.flush();
	 
	  System.out.println(data);
	}	
	catch(IOException e)
	{
		System.out.println(e);
	}
	}
	public static void main(String args[])
	{
		String data="";
		try(FileWriter fw=new FileWriter("D:\\core java\\outputm.csv");
				BufferedWriter bw= new BufferedWriter(fw);)
		{
		fw.write(data);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		FHMultipleRow fh=new FHMultipleRow() ;
		fh.readData(data);
	
	}

}
