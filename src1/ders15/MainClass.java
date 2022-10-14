package ders15;

public class MainClass {
	public static void main(String[] args) {
		Computer pc = new Computer();
		pc.model = "15";
		pc.price = 2000;
		pc.weight = 2;
		pc.ram = new Ram();
		pc.keyboard = new Keyboard();
		pc.prosessor = new Prosessor();
		pc.keyboard.keyboard_button_number = 70;
		pc.keyboard.price = 20;
		pc.ram.memory = 8;
		pc.ram.type = "ddr4";
		pc.prosessor.cpu_weight = 1;
		pc.prosessor.cpus_number = 4;
		pc.prosessor.name = "Ryzen";
		Prosessor prosessor = new Prosessor();
		Ram ram = new Ram();
		Keyboard keyboard = new Keyboard();
pc.printInfo();
pc.keyboard.printInfo();
pc.prosessor.printInfo();
pc.ram.printInfo();
	}

}
