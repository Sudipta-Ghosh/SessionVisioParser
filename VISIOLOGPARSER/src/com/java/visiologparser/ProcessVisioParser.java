package com.java.visiologparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessVisioParser {
	static List StaticFieldPatternList =new ArrayList();
	static List TaskdetailPatternList =new ArrayList();
	static String PatternStringForVariable="";
	static boolean isTaskStarted=false;
	static{
		StaticFieldPatternList= PatternInvoker.getRegularExpressionsForStaticFields();
		PatternStringForVariable= PatternInvoker.getRegularExpressionForVariable();
		TaskdetailPatternList=PatternInvoker.getRegularExpressionforTask();
	}
	
	public static Map getStaticDataforVisioParser(Map processMap,String lineContent){
		String strRegularExpression="";
		String strKey="";
	
		for(int counter=0;counter<StaticFieldPatternList.size();counter++){
			strRegularExpression=(String)StaticFieldPatternList.get(counter);
			Pattern pattern=Pattern.compile(strRegularExpression);
			Matcher matcher=pattern.matcher(lineContent);
			if(matcher.find()){
				StaticFieldPatternList.remove(strRegularExpression);
				strKey=matcher.group(1);
				strKey=strKey.substring(0, strKey.length()-1);
				processMap.put(strKey, matcher.group(2));
			}
		}
		
		return processMap;
		
	}
	
	public static List getSessionVariable(List arrList,String lineContent){
		Map processMap=new HashMap();
		Pattern pattern=Pattern.compile(PatternStringForVariable);
		Matcher matcher=pattern.matcher(lineContent);
		String strVariableName="";
		String strVariableType="";
		String strVariableValue="";
		if(matcher.find()){
			strVariableName=matcher.group(5);
			if(strVariableName!=null && strVariableName.indexOf("$$")!=-1){
				strVariableType="Mapping";
			}else{
				strVariableType="Session";
			}
			strVariableValue=matcher.group(3);
			
			processMap.put("VARIABLENAME", strVariableName);
			processMap.put("VARIABLENTYPE", strVariableType);
			processMap.put("VARIABLEVALUE", strVariableValue);
			arrList.add(processMap);
		}
		return arrList;
		
	}
	
	public static List getSessionDetails(List arrList,String lineContent,boolean sessionJustCompleted){
		String strRegularExpression="";
		String strSessionType="";
		String strobjectType="";
		String strobjectName="";
		String strTaskDetails="";
		Map processMap=new HashMap();
		for(int counter=0;counter<TaskdetailPatternList.size();counter++){
			strRegularExpression=(String)TaskdetailPatternList.get(counter);
			Pattern pattern=Pattern.compile(strRegularExpression);
			Matcher matcher=pattern.matcher(lineContent);
			if(matcher.find()){
				if(isTaskStarted){
					if(strTaskDetails!=null && lineContent.indexOf("Executing")==-1){
						if(strTaskDetails!=null && lineContent.indexOf("Completed")!=-1){;
						isTaskStarted=false;
						TaskdetailPatternList=PatternInvoker.getRegularExpressionforTask();
						sessionJustCompleted=true;
						}
					}else{
						processMap=(Map) arrList.get(arrList.size()-1);
						strTaskDetails=matcher.group(6)+"\n";
						if((String)processMap.get("TASKDETAILS")!=null && !((String)processMap.get("TASKDETAILS")).equals("")){
							strTaskDetails=strTaskDetails+(String)processMap.get("TASKDETAILS");
						}else{
							strTaskDetails	=strTaskDetails;
						}
						processMap.put("TASKDETAILS", strTaskDetails);
						sessionJustCompleted=false;
					}
					
				}
				if(!sessionJustCompleted){
				if(TaskdetailPatternList!=null && TaskdetailPatternList.size()==3){
					strSessionType=matcher.group(2)+" session";
					strobjectType=matcher.group(3);
					strobjectName=matcher.group(6);
					processMap.put("SESSIONTYPE", strSessionType);
					processMap.put("OBJECTTYPE", strobjectType);
					processMap.put("OBJECTNAME", strobjectName);
					arrList.add(processMap);
					isTaskStarted=true;
					TaskdetailPatternList.remove(strRegularExpression);
					sessionJustCompleted=false;
				}
				}
				
				
				
				
				
			}
			
		}
		return arrList;
		
	}

}
