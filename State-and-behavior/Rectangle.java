package stateandbehavior;

public class Rectangle {

	private int maxX;
	private int minX;
	private int maxY;
	private int minY;
	
//	public Rectangle(int minX,int maxX, int minY, int maxY) {
//		this.minX = minX;
//		this.maxX = maxX;
//		this.minY = minY;
//		this.maxY = maxY;
//	}
	
	public Rectangle() {
		maxX = 0;
		minX = 0;
		maxY = 0;
		minY = 0;
	}
	
	public int getMinX() {
		return this.minX;
	}
	
	public void setMinX(int minx) {
		this.minX = minx;
	}
	
	
	
	public int getMinY() {
		return this.minY;
	}
	
	public void setMinY(int miny) {
		this.minY = miny;
	}
	
	public int getMaxX() {
		return this.maxX;
	}
	
	public void setMaxX(int maxx) {
		this.maxX = maxx;
	}
	public int getMaxY() {
		return this.maxY;
	}
	
	public void setMaxY(int maxy) {
		this.maxY = maxy;
	}
	
	public int getWidth() {
		if (this.isEmpty()) {
			return 1;
			}
		
		else {
			return maxX-minX;
		}
	}
	
	public int getHeight() {
		if(!this.isEmpty()) {
			return maxY-minY;
			}
		
		else {
			return 1;
		}
	}
	
	public boolean isEmpty() {
		if (this.minX == 0 && this.minY == 0 && this.maxX == 0 && this.maxY == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		
		if(x > minX && x < maxX && y > minY && y < maxY) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public boolean contains(Rectangle rect) {
		
		if (this.minX < rect.minX && this.maxX > rect.maxX && this.minY < rect.minY && this.maxY > rect.maxY) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public boolean add(int x, int y) {
		if (!contains(x,y)) {
			if (this.isEmpty()) {
				this.setMinX(x);
				this.setMaxX(x);
				this.setMinY(y);
				this.setMaxY(y);
			}
			
			else {
				if (x < minX) {
					minX = x;}
				if (x > maxX) {
					maxX = x;}
				if (y < minY) {
					minY = y;}
				if (y > maxY) {
					maxY = y;}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean add(Rectangle rect) {
		if (!contains(rect)) {
			if (rect.minX < this.minX) {
				this.minX = rect.minX;}
			if (rect.maxX > this.maxX) {
				this.maxX = rect.maxX;}
			if (rect.minY < this.minY) {
				this.minY = rect.minY;}
			if (rect.maxY > this.maxY) {
				this.maxY = rect.maxY;}
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public String toString() {
		return "minX: " + minX + "maxX: " + maxX + "minY: " + minY + "maxY: " + maxY;
	}
	
	public Rectangle union(Rectangle rect) {
		Rectangle ny_rect = new Rectangle();
		if (rect.minX < this.minX) {
			ny_rect.minX = rect.minX;}
		if (rect.maxX > this.maxX) {
			ny_rect.maxX = rect.maxX;}
		if (rect.minY < this.minY) {
			ny_rect.minY = rect.minY;}
		if (rect.maxY > this.maxY) {
			ny_rect.maxY = rect.maxY;}
		return ny_rect;
	}
	
	public static void main(String [] args) {
		
		System.out.println("tomt rektangel:");
		Rectangle rect1 = new Rectangle();
		System.out.println(rect1);
		System.out.println("Er rektangelet tomt?: " + rect1.isEmpty());
		System.out.println("minX:" + rect1.getMinX());
		System.out.println("maxX:" + rect1.getMaxX());
		System.out.println("minY:" + rect1.getMinY());
		System.out.println("maxY:" + rect1.getMaxY());
		System.out.println("Inneholder rektangelet punktet(1,2)?:" + rect1.contains(1, 2));
		System.out.println("Høyde: " + rect1.getHeight());
		System.out.println("Bredde: " + rect1.getWidth());
		
		System.out.printf("%n");
		System.out.println( "ikke-tomt rektangel");
		rect1.setMaxX(5);
		rect1.setMaxY(5);
		System.out.println(rect1);
		System.out.println("Er rektangelet tomt?: " + rect1.isEmpty());
		System.out.println("Inneholder rektangelet punktet(1,2)?:" + rect1.contains(1, 2));
		System.out.println("Inneholder rektangelet punktet(-1,-2)?:" + rect1.contains(-1, -2));
		System.out.println("Høyde: " + rect1.getHeight());
		System.out.println("Bredde: " + rect1.getWidth());
		
		System.out.printf("%n");
		Rectangle rect2 = new Rectangle();
		rect2.add(2, 3);
		System.out.println("Rektangel (2,3)");
		System.out.println("maxX: " + rect2.getMaxX());
		System.out.println("maxY: " + rect2.getMaxY());
		System.out.println("minX:" + rect2.getMinX());
		System.out.println("minY:" + rect2.getMinY());
		
	}
}
