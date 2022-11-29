package finals;


import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class dinnerMenuList 
{
	public ArrayList<ArrayList<String>> menuList;
	public ArrayList<String> riceMealList;
	public ArrayList<String> sidesList;
	public ArrayList<String> beverageList;
	public ArrayList<String> dessertsList;
	
	public ArrayList<String> riceMealPriceList;
	public ArrayList<String> sidesPriceList;
	public ArrayList<String> beveragePriceList;
	public ArrayList<String> dessertsPriceList;
	
	
	
	String riceMealString = "res/Dinner meal with rice.txt";
	String sidesString = "res/Dinner sides.txt";
	String beverageString = "res/Dinner beverages.txt";
	String dessertsString = "res/Dinner desserts.txt";
	
	String riceMealPrice = "res/Dinner meal with rice(PRICE).txt";
	String sidesPrice = "res/Dinner sides(PRICE).txt";
	String beveragePrice = "res/Dinner beverages(PRICE).txt";
	String dessertsPrice = "res/Dinner desserts(PRICE).txt";
	
	File riceMealFile = new File (riceMealString);
	File sidesFile = new File (sidesString);
	File beverageFile = new File (beverageString);
	File dessertsFile = new File (dessertsString);
	
	File riceMealPriceFile = new File (riceMealPrice);
	File sidesPriceFile = new File (sidesPrice);
	File beveragePriceFile = new File (beveragePrice);
	File dessertsPriceFile = new File (dessertsPrice);	
	 

	
	public void readList() throws IOException
	{
		riceMealList = new ArrayList<String>();
		sidesList = new ArrayList<String>();
		beverageList = new ArrayList<String>();
		dessertsList = new ArrayList<String>();
		
		BufferedReader reader_1 = new BufferedReader(new FileReader(riceMealString));
	    String currentLine_1 = reader_1.readLine();
	    reader_1.close();
	    String[] tokens_1 = currentLine_1.split(",");
	    Collections.addAll(riceMealList, tokens_1);
	    
	    BufferedReader reader_2 = new BufferedReader(new FileReader(sidesString));
	    String currentLine_2 = reader_2.readLine();
	    reader_2.close();
	    String[] tokens_2 = currentLine_2.split(",");
	    Collections.addAll(sidesList, tokens_2);
	    
	    BufferedReader reader_3 = new BufferedReader(new FileReader(beverageString));
	    String currentLine_3 = reader_3.readLine();
	    reader_3.close();
	    String[] tokens_3 = currentLine_3.split(",");
	    Collections.addAll(beverageList, tokens_3);
	    
	    BufferedReader reader_4 = new BufferedReader(new FileReader(dessertsString));
	    String currentLine_4 = reader_4.readLine();
	    reader_4.close();
	    String[] tokens_4 = currentLine_4.split(",");
	    Collections.addAll(dessertsList, tokens_4);
	}
	
	public void writeList(File file, ArrayList<String> list) throws IOException
	{
		FileWriter fw = new FileWriter(file);
  	  	BufferedWriter bw = new BufferedWriter(fw);
  	  	PrintWriter pw = new PrintWriter(bw);

  	  
  	  String formattedList = list.toString().replaceAll("(^\\[|\\]$)","");
  	  
  	  String noSpaceList = formattedList.replaceAll("\\s","");
  	  pw.print(noSpaceList);
  	  
  	  pw.close();
	}
	
	public void readPriceList() throws IOException
	{
		riceMealPriceList = new ArrayList<String>();
		sidesPriceList = new ArrayList<String>();
		beveragePriceList = new ArrayList<String>();
		dessertsPriceList = new ArrayList<String>();
		
		BufferedReader reader_1 = new BufferedReader(new FileReader(riceMealPrice));
	    String currentLine_1 = reader_1.readLine();
	    reader_1.close();
	    String[] tokens_1 = currentLine_1.split(",");
	    Collections.addAll(riceMealPriceList, tokens_1);
	    
	    BufferedReader reader_2 = new BufferedReader(new FileReader(sidesPrice));
	    String currentLine_2 = reader_2.readLine();
	    reader_2.close();
	    String[] tokens_2 = currentLine_2.split(",");
	    Collections.addAll(sidesPriceList, tokens_2);
	    
	    BufferedReader reader_3 = new BufferedReader(new FileReader(beveragePrice));
	    String currentLine_3 = reader_3.readLine();
	    reader_3.close();
	    String[] tokens_3 = currentLine_3.split(",");
	    Collections.addAll(beveragePriceList, tokens_3);
	    
	    BufferedReader reader_4 = new BufferedReader(new FileReader(dessertsPrice));
	    String currentLine_4 = reader_4.readLine();
	    reader_4.close();
	    String[] tokens_4 = currentLine_4.split(",");
	    Collections.addAll(dessertsPriceList, tokens_4);
	}
	
	public void writePriceList(File file, ArrayList<String> list) throws IOException
	{
		FileWriter fw = new FileWriter(file);
  	  	BufferedWriter bw = new BufferedWriter(fw);
  	  	PrintWriter pw = new PrintWriter(bw);

  	  
  	  String formattedList = list.toString().replaceAll("(^\\[|\\]$)","");
  	  
  	  String noSpaceList = formattedList.replaceAll("\\s","");
  	  pw.print(noSpaceList);
  	  
  	  pw.close();
	}
	
	
	
	
	
}
