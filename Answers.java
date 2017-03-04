package randomQA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Answers {
	private ArrayList <String> answerList;
	public Answers(File file){
		answerList = new ArrayList <String> ();
		try{
			BufferedReader reader = new BufferedReader (new FileReader (file));
			String temp="1";
			while (temp!=null){
				temp=reader.readLine();
				answerList.add(temp);
			}
			reader.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public ArrayList<String> getAnswerList() {
		return answerList;
	}
}
