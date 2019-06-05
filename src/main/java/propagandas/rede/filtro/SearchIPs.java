package propagandas.rede.filtro;

import java.util.ArrayList;

public class SearchIPs {

	public static ArrayList<String> searchSite(String txt) {
		
		ArrayList<Integer> positions = new ArrayList<Integer>();
		
		ArrayList<String> ips = new ArrayList<String>();
		
		String[] tokens = txt.split(" "); 
		
		for (int i = 0; i < tokens.length; i++) {			
			if(tokens[i].equalsIgnoreCase("de")) {
				positions.add(i+1);
			}
		}
		
		for (int i = 0; i < tokens.length; i++) {
			for (Integer position : positions) {
				if(i == position) {
					ips.add(tokens[i].toString());
				}
			}
		}
		
		return ips;
	}
}
