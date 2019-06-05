package propagandas.rede;

import java.io.IOException;
import java.util.ArrayList;

import propagandas.rede.comandos.CommandSearchExecution;
import propagandas.rede.filtro.SearchIPs;

public class Main {

	public static void main(String[] args) throws IOException {
		String txt = CommandSearchExecution.execCommand("ping google.com");
		
		ArrayList<String> ips = new ArrayList<String> (SearchIPs.searchSite(txt));
		
		for (String string : ips) {
			CommandSearchExecution.execCommand("ping " + string);
		}
	}

}
