package randomQA;

public class Helper {
	private int max,min;
	public Helper(int min,int max){
		this.max=max;
		this.min=min;
	}
	public int randomNumber(){
		int ans = (int)((max-min)*Math.random())+min;
		return ans;
	}
}
