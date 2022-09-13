package ders6.misal;

public class AgacMeselesi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int agachundurluk=20;
double verilensu=1;
agachundurluk=agachundurluk+2;
int gun;
while(agachundurluk<=30) {
	gun++;
	verilensu*=1.5;
			agachundurluk=verilensu*2;
}System.out.println(gun);
	}

}
