package com.java.visiologparser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternInvoker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String InputPatternRegex ="(Starting (Post|Pre) SQL for (target|source)(\\s+\\S+|\\S+\\s+)(\\s+|)\\[)(\\S+)(\\])";
		String strInputString="2013-06-11 08:34:00 : INFO : (16449750 | MAPPING) : (IS | matti) : Node01_matti : TM_6781 : TM_6781 Starting Pre SQL for target : [INS_SOR_ARRANGEMENT]. : (2013.06.11 08:34:00);";
        Pattern pattern=Pattern.compile(InputPatternRegex);
        Matcher matcher=pattern.matcher(strInputString);
		if(matcher.find()){
			System.out.println("matcher--->"+matcher.groupCount());
			System.out.println("matcher--->"+matcher.group(6));
		}

	}
	
	public static List<String> getRegularExpressionsForStaticFields(){
		List<String> arrList=new ArrayList<String>();
		String InputPatternRegexForServiceName="(Server Name:\\s+\\[)(\\S+)(\\])";
		String InputPatternRegexForNodeName="(Integration Service\\s+\\[)(\\S+)(\\])";
		//String InputPatternRegexForSessionStartTime="(Server Name:\\s+\\[)(\\S+)(\\])";
		String InputPatternRegexForRepositoryName="(Repository Name:\\s+\\[)(\\S+)(\\])";
		String InputPatternRegexForFolderName="(Folder:\\s+\\[)(\\S+)(\\])";
		String InputPatternRegexForServerMode="(Server Mode:\\s+\\[)(\\S+)(\\])";
		String InputPatternRegexForIntegrationBitSize="(is run by\\s+)(\\S+)(\\-bit Integration Service)";		
		String InputPatternRegexForServerCodePage="(Server Code page:\\s+\\[)((\\S+\\s).*)(\\])";
		String InputPatternRegexForSortOrder="(The session sort order is\\s+\\[)(\\S+)(\\])";
		String InputPatternRegexForPrecision="(Using\\s+)(\\S+)(\\s+precision processing)";
		String InputPatternRegexForCommitType="(Server Name:\\s+\\[)(\\S+)(\\])";
		String InputPatternRegexForCommitInterVal="(commit interval is\\s+\\[)(\\S+)(\\])";
		String InputPatternRegexForDTMErrorLog="(DTM error log\\s+)(\\S+)(\\.)";
		
		arrList.add(InputPatternRegexForServiceName);
		arrList.add(InputPatternRegexForNodeName);
		//arrList.add(InputPatternRegexForSessionStartTime);
		arrList.add(InputPatternRegexForRepositoryName);
		arrList.add(InputPatternRegexForFolderName);
		arrList.add(InputPatternRegexForServerMode);
		arrList.add(InputPatternRegexForIntegrationBitSize);
		arrList.add(InputPatternRegexForServerCodePage);
		arrList.add(InputPatternRegexForSortOrder);
		arrList.add(InputPatternRegexForPrecision);
		arrList.add(InputPatternRegexForCommitType);
		arrList.add(InputPatternRegexForCommitInterVal);
		arrList.add(InputPatternRegexForDTMErrorLog);
		return arrList;
		
	}
	
	public static String getRegularExpressionForVariable(){
		String regularExpressionForVariable="((Use override value|Use default value)\\s+\\[)(\\S+)(\\]\\s+for server variable:\\[)(\\S+)(\\])";
		return regularExpressionForVariable;
		
	}
	
	public static List getRegularExpressionforTask(){
		List<String> arrList=new ArrayList<String>();
		String strInputForStartString="(Starting (Post|Pre) SQL for (target|source)(\\s+\\S+|\\S+\\s+|)(\\s+|)\\[)(\\S+)(\\])";
		String strInputFortaskDetails="(Executing (pre|post)-session SQL for (target|source))(\\s+|)(\\S+)((\\s+\\S+|\\S+\\s+).*)(\\;)";
		String strInputForEndString="Completed (Post|Pre) SQL for (target|source)";
		arrList.add(strInputForStartString);
		arrList.add(strInputFortaskDetails);
		arrList.add(strInputForEndString);
		return arrList;
		
	}
		
	

}
