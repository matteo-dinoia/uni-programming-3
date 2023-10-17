package model;

import model.processors.Processor;
import model.screens.Screen;

public class Pc {
	private Processor cpu;
	private Screen display;

	public Pc(Processor cpu, Screen display){
		this.cpu = cpu;
		this.display = display;
	}

	public String getConfiguration(){
		return "Pc config:"
			+ "\n * CPU: " + cpu.getName()
			+ "\n * DISPLAY: " + display.getName()
			+ "\n";
	}

	public int getTotalPrice(){
		return cpu.getPrice() + display.getPrice();
	}

}
