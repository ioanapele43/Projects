package business;
import javax.swing.JOptionPane;

public class ExceptieStringGresit extends Exception{
	public ExceptieStringGresit(String a) {
		super(a);
		JOptionPane.showMessageDialog(null,a);
	}
}