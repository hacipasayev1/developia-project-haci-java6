package ders22;

import java.util.ArrayList;

public class Ders22Calisma2 {
public static void main(String[] args) {
	ArrayList<Computer> computer=new ArrayList<Computer>();
	computer.add(new Computer(1, "hp", 6));
	computer.add(new Computer(2, "lenovo", 8));
	computer.add(new Computer(3, "toshiba", 16));
	System.out.println(computer);
}
}
