package fajfr.cookbook;

import java.util.StringTokenizer;

public class StrTokDemo4 {

	//pokud pracuju p��mo uvnit� spou�t�c� static main() funkce, tak musim pracovat se statick�mi prom�nn�mi 
	public final static int MAXPOLI=5;
	public final static String ODDELOVAC="|";
	
	//pokud pracuju p��mo uvnit� spou�t�c� static main() funkce, tak musim pracovat se statick�mi funkcemi 
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
		  //funkce process mus� b�t typu String[] aby mohly vyhazovat typ pole (return vysledky)
		//diky tomuto mi funkce process() vyhod� textov� �et�zce v main()
		 return vysledky;
		
	}
	
//	Druh�m argumentem t�to static� funkce je p�edchoz� statick� funkce process,
//	datov� typ argumentu mus� b�t stejn� (tedy String[]) ale n�zev argument m��e b�t libovoln�,
//	je to zkr�tka prom�nn�, tak�e pokud se argument jmenuje vystupy a urcim mu datov� tip String[]
//	a pak tam p�i spu�t�n� d�m funkci process() datov�ho tipu String[] tak to proste fungovat bude!!
	
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
