package randomQA;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
public class Questions {
	private ArrayList <String> questionList;
	public Questions(File file){
		questionList = new ArrayList <String> ();
		try{
			BufferedReader reader = new BufferedReader (new FileReader (file));
			String temp = "1";
			while (temp!=null){
				temp=reader.readLine();
				questionList.add(temp);
			}
			reader.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public ArrayList<String> getQuestionList() {
		return questionList;
	}
}
