package com.java.visiologparser.web.jsf.beans;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;  
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile; 

import com.java.visiologparser.common.TempFileWriter;
import com.java.visiologparser.common.UploadFile;

@ManagedBean
@SessionScoped
public class FileUploadBean implements Serializable
{     
private ArrayList<UploadFile> files = new ArrayList<UploadFile>(); 
private int uploadsAvailable = 5;
private boolean autoUpload = false;
private boolean useFlash = false;

public int getSize() {
    if (getFiles().size()>0){
        return getFiles().size();
    }else 
    {
        return 0;
    }
}



public void paint(OutputStream stream, Object object) throws IOException {
	stream.write(getFiles().get((Integer) object).getData());   
	stream.close();   
}     
public void listener(FileUploadEvent event) throws Exception {  
	UploadedFile item = event.getUploadedFile(); 
	UploadFile file = new UploadFile();   
	file.setLength(item.getData().length);  
	String strFileName=item.getName();
	strFileName=strFileName.substring(strFileName.lastIndexOf("\\")+1, strFileName.length());
	file.setName(strFileName);  
	String str = new String(item.getData());
	file.setData(item.getData());   
	TempFileWriter.createTempDirectory(item.getData(), item.getName());
	files.add(file);  
	 uploadsAvailable--;

} 

	public String clearUploadData() { 
		setUploadsAvailable(5);
		files.clear();  
		return null;   
	}      


	  public int getUploadsAvailable() {
	        return uploadsAvailable;
	    }
	
	    public void setUploadsAvailable(int uploadsAvailable) {
	        this.uploadsAvailable = uploadsAvailable;
	    }


	    public boolean isAutoUpload() {
	        return autoUpload;
	    }

	    public void setAutoUpload(boolean autoUpload) {
	        this.autoUpload = autoUpload;
	    }

	    public boolean isUseFlash() {
	        return useFlash;
	    }

	    public void setUseFlash(boolean useFlash) {
	        this.useFlash = useFlash;
	    }




	public String getTimeStamp() { 
		SimpleDateFormat parser = new SimpleDateFormat("EEE, MMM dd, yyyy");
		Date resultdate = new Date(System.currentTimeMillis());
		String strSystemDate=parser.format(resultdate);

		return strSystemDate;
	}   

	public ArrayList<UploadFile> getFiles() { 
		return files;   
	}   
	public void setFiles(ArrayList<UploadFile> files) {   
		this.files = files;   
	} 
}