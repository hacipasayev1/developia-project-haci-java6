package constructors.home;

public class Ededi_Orta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int eded=67;
int b=0;
int c=0;
while(eded!=0) {
	b+=b%10;
	b/=10;
	c++;
}
System.out.println(b/c);
	}

}
