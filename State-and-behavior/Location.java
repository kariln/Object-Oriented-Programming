package stateandbehavior;

public class Location {
	
	public int X;
	public int Y;
	
	public void up() {
		this.Y -= 1;
	}
	
	public void down() {
		this.Y += 1;
	}
	
	public void left() {
		this.X -= 1;
	}
	
	public void right() {
		this.X += 1;
	}
	
	public int getX() {
		return X;
	}
	
	public int getY() {
		return Y;
	}
	
	public void Main() {
		left();
		up();
		right();
		down();
		
	}
	
	public String toString() {
		return ""+ getX()+ " "+ getY();
	}
}
