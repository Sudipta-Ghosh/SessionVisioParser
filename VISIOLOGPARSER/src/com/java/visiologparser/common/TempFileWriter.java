package com.java.visiologparser.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TempFileWriter {

	
	public static void createTempDirectory(byte[] data,String strFileName) 
		{
		String strTemporaryFileLoc=System.getProperty("java.io.tmpdir");
		strFileName=strFileName.substring(strFileName.lastIndexOf("\\"), strFileName.length());
		strTemporaryFileLoc="D:\\VisioLog";
		String strDirctoryName=strTemporaryFileLoc+"\\"+"VisioParser";
		
		 File fileOutputFolder = new File(strDirctoryName);
       	 if (!fileOutputFolder.exists())
			{
    		 fileOutputFolder.mkdir();
			}		
		String strFilePath=strTemporaryFileLoc+"\\"+"VisioParser"+strFileName;
		FileOutputStream fileOuputStream;
		try {
			fileOuputStream = new FileOutputStream(strFilePath);
			fileOuputStream.write(data);
		    fileOuputStream.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
		
		}
}
