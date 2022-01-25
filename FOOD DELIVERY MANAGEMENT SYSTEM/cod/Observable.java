package businessLayer;

import presentationLayer.Employee;
import presentationLayer.Observer;

public class Observable implements Observer{
	private Employee em;
	public Observable(Employee e) {
		em=e;
	}
	@Override
	public void update() {
		em.update();
		
	}
	
}
