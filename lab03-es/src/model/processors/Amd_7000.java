package model.processors;

public class Amd_7000 implements Processor{
	@Override
	public int getPrice() {
		return 200;
	}

	@Override
	public String getName() {
		return "AMD 7000";
	}
}
