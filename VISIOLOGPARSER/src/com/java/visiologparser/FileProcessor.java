package com.java.visiologparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class FileProcessor {
	
	public static void getSourceDirectory(){
		String strCurrentDirectory=System.getProperty("user.dir");
		String strConfigLocation=strCurrentDirectory+"/"+"config.properties";
		Properties prop = new Properties();
		String strSourceFolder="";
		String strOutputFolder="";
		boolean inputOutputLocFlag=false;
		try {
	    	prop.load(new FileInputStream(strConfigLocation));
	         strSourceFolder=(prop.getProperty("SOURCEDIRCTORY")).trim();
	         strOutputFolder=(prop.getProperty("OUTPUTDIECTORY")).trim();
	         if(strSourceFolder!=null && strSourceFolder.equalsIgnoreCase(strOutputFolder)){
	        	 inputOutputLocFlag=true;
	         }
	 		 File inputFolder =new File(prop.getProperty("SOURCEDIRCTORY"));
	 		 new FileProcessor().listFilesForFolder(inputFolder,strSourceFolder,strOutputFolder,inputOutputLocFlag);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	  public static void listFilesForFolder(File folder,String strSourceFolder,String strOutputFolder,boolean inputOutputLocFlag) throws IOException {
	        int Counter=0;
	        String strTempOutPutFolder="";
	        String strOutputFileLocation="";
		    for (File fileEntry : folder.listFiles()) {
		    	
		    	String [] fileList = folder.list();
		      if (fileEntry.isDirectory()) {
		    	     if (!inputOutputLocFlag){
		        	 strTempOutPutFolder=strOutputFolder+"\\"+fileList[Counter];
		        	 File fileOutputFolder = new File(strTempOutPutFolder);
		           	 if (!fileOutputFolder.exists())
						{
		        		 fileOutputFolder.mkdir();
						}
		         }
		          Counter++;
		         listFilesForFolder(fileEntry,strSourceFolder,strTempOutPutFolder,inputOutputLocFlag);
		        
		      } else {
		    	  Counter++;
		        if (fileEntry.isFile()) {
		            String strFileData=folder.getAbsolutePath()+"\\"+fileEntry.getName();
		            String strFileName=fileEntry.getName();	           
		            String strOutputFilePath=strOutputFolder+"\\"+fileEntry.getName();
		            File file = new File(strOutputFilePath);	         
		            file.createNewFile();		      
		            readfromSourceFile_WriteTargetFile(strFileData,strOutputFilePath);
		           
		        }
		      }
		    }
		}
	  public static String readValuesFrmPropertiesFile(String strInputKey){
			 
		  String strCurrentDirectory=System.getProperty("user.dir");
		  String strConfigLocation=strCurrentDirectory+"/"+"config.properties";
		  Properties prop = new Properties();
		  String strPropertyValue="";
		  strInputKey=strInputKey.trim();
		  try {
			prop.load(new FileInputStream(strConfigLocation));
			strPropertyValue=(prop.getProperty(strInputKey)).trim();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		return strPropertyValue;
		  
		  
	  }
	  public static void  readfromSourceFile_WriteTargetFile(String strFileData,String strOutputFilePath) throws IOException{
		  File file = new File(strFileData);
		  String lineContent ="";
		  PrintWriter objprintWriter = new PrintWriter(new FileOutputStream(strOutputFilePath));
		  Map processMapForStaticField=new HashMap();
		  List processListForVariable=new ArrayList();
		  List processListForTaskDetail=new ArrayList();
		  Map resultMap=new HashMap();
		  int lineNo=0;
		  boolean sessionJustCompleted=false;
		  
		  
		  try {		  
	          Scanner scanner = new Scanner(file);
	          while (scanner.hasNextLine()) {
	        	  lineContent = scanner.nextLine();	        	
	        	  processMapForStaticField=ProcessVisioParser.getStaticDataforVisioParser(processMapForStaticField,lineContent);
	        	  processListForVariable=ProcessVisioParser.getSessionVariable(processListForVariable,lineContent);
	        	  processListForTaskDetail=ProcessVisioParser.getSessionDetails(processListForTaskDetail, lineContent,sessionJustCompleted);
	          }
		  }catch(Exception e){
			  System.out.println("e====" +e.getMessage() );
		  }
		  if (objprintWriter != null) objprintWriter.close();
		 
		 
		  
		  Iterator itr =  processMapForStaticField.keySet().iterator();
		  String strValue="";
		  String strFinalKey="";
          while(itr.hasNext())
          {
                String key = (String) itr.next();
                strFinalKey=FileProcessor.readValuesFrmPropertiesFile(key);
                 strValue=(String) processMapForStaticField.get(key);
                 resultMap.put(strFinalKey, strValue);

           }
          System.out.println("resultMap====" +resultMap);
          System.out.println("processListForVariable====" +processListForVariable);
          System.out.println("processListForTaskDetail====" +processListForTaskDetail);
          new excelGeneratorforStaticField().writeExcelFile("D:\\sampleexcel.xls", resultMap);
	  }

}
