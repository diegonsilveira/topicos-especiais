package propagandas.rede;

import java.io.IOException;
import java.util.ArrayList;

import propagandas.rede.comandos.CommandSearchExecution;
import propagandas.rede.filtro.SearchIPs;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String txt = CommandSearchExecution
				.execCommand("tcpdump -i eth1 -S -vv -nn -l dst 10.8.32.80 | grep -1 \"ad\\.\" --line-buffered");
		
		ArrayList<String> ips = new ArrayList<String>(SearchIPs.searchSite(txt));

		String command = "tcpdump -i eth1 -S -vv -nn -l src ";
		int i = 0;
		int value = 0;
		
		for (String string : ips) {

			if (i != ips.size()) {
				command = command + string + " or ";
			} else {
				command = command + string;
			}
			i++;
		}
		
		String txt2 = CommandSearchExecution
				.execCommand(command);

		ArrayList<Integer> bytess = new ArrayList<Integer>(SearchIPs.searchBytes(txt2));
		
		for (Integer integer : bytess) {
			value = value + integer;
		}
		
		System.out.println("VALOR EM BYTES: " + value);

	}

}
