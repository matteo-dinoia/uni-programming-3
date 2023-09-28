import figures.Triangle;

public class Main {
	public static void main(String[] args) {
		Triangle t = new Triangle(11, 20);
		String[] attrs = t.describeAttributes();
		for(int i = 0; i < attrs.length; i++){
			System.out.println(attrs[i]);
		}

		System.out.println("\n" + t);
		t.setAttributes(new float[]{10, 20});
		System.out.println("\n" + t);

		System.out.println(t.equals(new Triangle(10,20)));

	}
}