/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laba8_pism;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;


public class  Laba8_PISM 
{
   
   public static void main(String args[]) throws FileNotFoundException, IOException 
   {
      
	ArrayList<String> obj = new ArrayList<String>(5);
        ArrayList<String> fake = new ArrayList<String>();
        ArrayList<Integer> fakeArray = new ArrayList<Integer>();
      
        System.out.println("Addiding and removing elements: ");
	/*This is how elements should be added to the array list*/
	obj.add("Ajeet");//Ajeet
	obj.add("Harry");//Harry
	obj.add("Chaitanya");//Chaitanya
	obj.add("Steve");//Steve
	obj.add("Ajeet");//Ajeet
        System.out.println("Current array list is:"+obj);
        
        /*Add element at the given index*/
	obj.add(0, "Rahul");
	obj.add(1, "Justin");
        System.out.println("Current array list after addiding elements:"+obj);

	//Remove elements
	obj.remove("Chaitanya");
	obj.remove("Harry");	 
        System.out.println("Current array list after removing elements:"+obj  +"\n");
        
        
        System.out.println("Searching for dublicates^ "); 
        HashMap<String, Integer> letters = new HashMap<String, Integer>();        
        for (int i = 0; i < obj.size(); i++) 
        {
            String tempChar = obj.get(i);
            if (!letters.containsKey(tempChar)) 
            {
                letters.put(tempChar, 1);
            } 
            else 
            {
                letters.put(tempChar, letters.get(tempChar) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : letters.entrySet()) {
        System.out.println(""+ entry.getKey() + ", Number of dublicates = " + entry.getValue());
        }     
        
        System.out.println("\n" + "Revers of elements: ");
        Collections.reverse(obj);
        System.out.println("After reverse" + obj +"\n");
       
        System.out.println("Statistics for all element: ");
         //Подсчет эл-ов, удостоверяющих конкретному условию 
        for (int a = 0; a < obj.size(); a++)
        {
            int yes=0;
            for (int b=0; b<obj.size(); b++) if (obj.get(a).length()>=obj.get(b).length()) yes++;
            if (yes==5)  //определяет нет ли больше стороки, чем выбранное кол-во символов, т.е.4
            System.out.println("The number of words that have more letters than the selected number: " +obj.get(a));
        }
        int max = obj.get(0).length();
        for (int i = 0; i < obj.size(); i++)
        {
            if (obj.get(i).length() > max)
            {
                max = obj.get(i).length();
                System.out.println("Words with max lenght: "+obj.get(i));
            }
            else if (obj.get(i).length() < max)
            {
                max = obj.get(i).length();
                System.out.println("Words with min lenght: "+obj.get(i));
            }
        }
        
        System.out.println("\n" + "Substring search:  ");
        int index = obj.lastIndexOf("Ajeet");
        if(index==-1)
        {
            System.out.println("Substring \"Ajeet\" not found");
        }else{
            System.out.println("Last occurrence of a string \"Ajeet\" in the index " + index);
        }
        
        
        System.out.println("\n" + "The same list after sorting string by length");
        Comparator<String> byLength = new Comparator<String>()
        {
            public int compare (String s1, String s2) 
            {
                return s1.length () - s2.length ();
            }
        };
        Collections.sort(obj, byLength);
        System.out.println(obj);
        
        
        System.out.println("\n" + "Initilizate list from File");
        FileReader fr = new FileReader("DOC.txt");
        Scanner scan = new Scanner(fr);
        int i=1;
        while (scan.hasNextLine()) 
        {
            System.out.println( i + " : " + scan.nextLine());
            i++;    
        }
        fr.close();

        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        
        for (int w=0; w<obj.size(); w++)
        {
            String s = reader.readLine();
             obj.add(4, s);
            obj.remove(0);
        //    obj.add(4, s);
            
            System.out.println(obj);
            
        }        
   }
}
   
