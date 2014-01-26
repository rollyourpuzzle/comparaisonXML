package com.rollyourpuzzle.comparaisonxml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Difference;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;



public class ComparaisonXML {
	public static void main(String[] args) throws JDOMException, IOException 
    {
        FileReader fr1 = null;
        int countofdifferences = 0;
        FileReader fr2 = null;
        try {
            fr1 = new FileReader("C:\\xml\\1.xml");
            fr2 = new FileReader("C:\\xml\\2.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
       
            Diff lDiff = new Diff(fr1, fr2);
            MyDifferenceListener lListener = new MyDifferenceListener();
            lDiff.overrideDifferenceListener(lListener);
            //System.out.println("Similar? " + lDiff.similar());
            //System.out.println("Identical? " + lDiff.identical());

            
            DetailedDiff detDiff = new DetailedDiff(lDiff);
           
           
            
            @SuppressWarnings("unchecked")
			List<Difference> differences = detDiff.getAllDifferences();
            
            for (Object object : differences) {
            	
            	Difference difference = (Difference) object;         	
                
                System.out.println("------------------------");
                System.out.println(difference.toString());
                System.out.println("------------------------");
                countofdifferences++;
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(countofdifferences);
        System.exit(0);
    }
	
	   }

