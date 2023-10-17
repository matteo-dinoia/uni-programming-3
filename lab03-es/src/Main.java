import model.Pc;
import model.processors.Amd_7000;
import model.processors.Intel12_7770H;
import model.screens.CrappyTM;
import model.screens.Oled;

public class Main {
	public static void main(String[] args) {
		Pc pc = new Pc(new Amd_7000(), new Oled());
		System.out.println(pc.getConfiguration() + "cost: " + pc.getTotalPrice() + "\n");

		pc = new Pc(new Intel12_7770H(), new CrappyTM());
		System.out.println(pc.getConfiguration() + "cost: " + pc.getTotalPrice() + "\n");

	}
}