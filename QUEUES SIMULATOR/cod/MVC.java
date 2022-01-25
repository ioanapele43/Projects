package gui;

public class MVC {
	public static void main(String[] args) {
		   Model model=new Model();
		   Frame frame=new Frame(model);
		   FirstFrame frame2=new FirstFrame(model);
		   Controller controller=new Controller(model,frame,frame2);
		   frame2.setVisible(true);
	   }
}
