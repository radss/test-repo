package fajfr.cookbook;
//strana 195 Cookbook
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class ReminderService {
	Timer casovac = new Timer();
	
class Item extends TimerTask {
	String zprava;
	
	Item(String m){
		//pøiøazení hodnoty mùže být i obrácenì. Klasicky by bylo this.zprava=m
		m=zprava;
	}
	
	public void run(){
		message(zprava);
	}
}
	public static void main(String[] argv) throws IOException{
		//new ReminderService.load();
		new ReminderService().load();
	}
	
	protected void load() throws IOException{
		BufferedReader is = new BufferedReader(new FileReader("C:/Users/Dell/Desktop/ReminderService.txt"));
		SimpleDateFormat formatovac = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
		String aRadek;
		
		while((aRadek=is.readLine())!=null){
			//Na øádku s indexem 0 vysekej datum
			ParsePosition pp = new ParsePosition(0);
			Date datum =  (Date) formatovac.parse(aRadek,pp);
			
			if(datum==null){
				message("Neplatne datum na radku " + aRadek);
				continue;
			}
		String zprava = aRadek.substring(pp.getIndex());
		casovac.schedule(new Item(zprava),datum);
	}
		is.close();
}

	void message(String zprava){
		System.out.println("\007" + zprava);
		JOptionPane.showMessageDialog(null, zprava, "Upominka casovace", JOptionPane.INFORMATION_MESSAGE);
	}
}


	

