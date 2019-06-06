package propagandas.rede.filtro;

import java.util.ArrayList;

public class SearchIPs {

	public static ArrayList<String> searchSite(String txt) {
		
		ArrayList<Integer> positions = new ArrayList<Integer>();
		
		ArrayList<String> ips = new ArrayList<String>();
		
		String[] tokens = txt.split(" "); 
		
		for (int i = 0; i < tokens.length; i++) {			
			if(tokens[i].equals("A")) {
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
	
	public static ArrayList<Integer> searchBytes(String txt){
		ArrayList<Integer> positions = new ArrayList<Integer>();
		
		ArrayList<Integer> bts = new ArrayList<Integer>();
		
		String[] tokens = txt.split(" "); 
		
		for (int i = 0; i < tokens.length; i++) {			
			if(tokens[i].equals("length")) {
				positions.add(i+1);
			}
		}
		
		for (int i = 0; i < tokens.length; i++) {
			for (Integer position : positions) {
				if(i == position) {
					String temp = tokens[i].toString().replace(")","");
					Integer bt = Integer.parseInt(temp);
					bts.add(bt);
				}
			}
		}
		
		return bts;
		
	}
}
