package fajfr.cookbook;

import java.util.StringTokenizer;

public class StrTokDemo4 {

	//pokud pracuju pøímo uvnitø spouštìcí static main() funkce, tak musim pracovat se statickými promìnnými 
	public final static int MAXPOLI=5;
	public final static String ODDELOVAC="|";
	
	//pokud pracuju pøímo uvnitø spouštìcí static main() funkce, tak musim pracovat se statickými funkcemi 
	public static String[] process(String radek){
		
		String[] vysledkyyyyyyyyyyyyyyyyyy = new String[MAXPOLI];
		StringTokenizer st = new StringTokenizer(radek, ODDELOVAC, true);
		
		int i=0;
		
		while(st.hasMoreTokens()){
			String s = st.nextToken();
			if(s.equals(ODDELOVAC)){
				if(i++>=MAXPOLI)
					throw new IllegalArgumentException("Vstupni radek "+
				        radek + "ma prilis mnoho poli");
							continue;
			}
			vysledky[i]=s;
		}
		  //funkce process musí být typu String[] aby mohly vyhazovat typ pole (return vysledky)
		//diky tomuto mi funkce process() vyhodí textové øetìzce v main()
		 return vysledky;
		
	}
	
//	Druhým argumentem této staticé funkce je pøedchozí statická funkce process,
//	datový typ argumentu musí být stejný (tedy String[]) ale název argument mùže být libovolný,
//	je to zkrátka promìnná, takže pokud se argument jmenuje vystupy a urcim mu datový tip String[]
//	a pak tam pøi spuštìní dám funkci process() datového tipu String[] tak to proste fungovat bude!!
	
	public static void printResults(String vstup, String[] vystupy){
		System.out.println("Vstup: " + vstup);
		   for(int i=0;i<vystupy.length;i++){
			   System.out.println("Vystupem pole "+ i + "bylo: "+ vystupy[i]);
		   }
		
	}
	
public static void main(String[] args) {
		
		StrTokDemo4 strToK =  new StrTokDemo4();
		
		printResults("A|B|C|D",process("A|B|C|D"));
		printResults("A|||D",process("A|||D"));

	}
	
}
