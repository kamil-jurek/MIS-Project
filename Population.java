package badania;

import java.util.*;

public class Population {
	private LinkedList<Chromosome> population = new LinkedList<Chromosome>();
	public int[][] adjMatrix;
	
	Population(int length, int chromNum,int[][] adj) {
		for(int i = 0; i < length; i++) {
			adjMatrix = adj.clone();
			Chromosome newChrom = new Chromosome(chromNum);
			newChrom.init();
			newChrom.fitness(adjMatrix);
			
			population.add(newChrom);
		}
	}
	
	public Chromosome get(int i) {
		return population.get(i);
	}
	
	public void add(Chromosome newChrom) {
		population.add(newChrom);
	}

	public void removeLast() {
		population.removeLast();
	}
	
	public void sort() {
		Collections.sort(population, new chromComp());
	}
	
	public void print(int gen) {
		String wynik = "Generacja: " + gen + "\n";
		wynik += "nr   fitness:   chromosom: \n";
		for(int j = 0 ; j < population.size(); j++) {
   		  	wynik += (j+1 + ".    " + population.get(j).fit + "          ");
	    	  for(int i = 0; i < population.get(j).size(); i++) {
	    		  wynik += ( population.get(j).get(i) + "  ");	  
	    	  }
	    	  wynik+="\n";
   	    }
		wynik+="\n\n";
		Window.displayMessage(wynik);
	}
	
	private class chromComp implements Comparator<Chromosome> {
		
	    public int compare(Chromosome e1, Chromosome e2) {
	        if(e1.fit == e2.fit) {
	        	return 0;
	        } else if( e1.fit < e2.fit) {
	            return 1;
	        } else {
	            return -1;
	        }
	    }
	}
}
