package figures;

public class Triangle extends Polygon{
	float base;
	float height;

	public Triangle(float base, float height) {
		super(3);
		this.base = base;
		this.height = height;
	}

	@Override public float getArea(){
		return base * height / 2.0f;
	}


}
