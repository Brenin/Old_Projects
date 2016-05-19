package printing;

public class PrintTopLine {
	private static LineBreak lb = new LineBreak();
	private static PrintStars ps = new PrintStars();
	
	public void topStatusLine(){
		ps.printStars();
		System.out.print("Status");
		ps.printStars();
		lb.lineBreak();
	}
}
