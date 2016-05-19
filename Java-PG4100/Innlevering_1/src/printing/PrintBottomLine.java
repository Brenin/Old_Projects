package printing;

public class PrintBottomLine {
	private static LineBreak lb = new LineBreak();
	
	public void bottomStatusLine(){
		for(int i = 0; i < 106; i++){
			System.out.print("*");
		}
		lb.lineBreak();
	}
}
