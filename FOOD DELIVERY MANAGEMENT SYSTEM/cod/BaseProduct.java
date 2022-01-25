package businessLayer;

public class BaseProduct extends MenuItem {
	//private String title;
	private float rating;
	private int calories;
	private int proteins;
	private int fats;
	private int sodium;
	//private int price;
	 BaseProduct(){
		 super.setTitle("");
		rating=0;
		calories=0;
		proteins=0;
		fats=0;
		sodium=0;
		super.setPrice(0);
	}
	public BaseProduct(String s, float r, int c, int p, int f, int so, int pr){
		//title=s;
		super.setTitle(s);
		rating=r;
		calories=c;
		proteins=p;
		fats=f;
		sodium=so;
		super.setPrice(pr);
	}
	
	public float getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int getProteins() {
		return proteins;
	}
	public void setProteins(int proteins) {
		this.proteins = proteins;
	}
	public int getFats() {
		return fats;
	}
	public void setFats(int fats) {
		this.fats = fats;
	}
	public int getSodium() {
		return sodium;
	}
	public void setSodium(int sodium) {
		this.sodium = sodium;
	}
	
	
}
