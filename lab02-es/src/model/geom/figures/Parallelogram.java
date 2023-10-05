package model.geom.figures;

public class Parallelogram extends Polygon{
	float base;
	float height;
	float oblique;

	public Parallelogram(float base, float height, float oblique) {
		super(4);
	}

	@Override public float getArea(){
		return base * height;
	}

	public float getPerimeter(){
		return (base + oblique) * 2.0f;
	}


}
