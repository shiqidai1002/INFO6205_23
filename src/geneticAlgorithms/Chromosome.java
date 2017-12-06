package geneticAlgorithms;
public class Chromosome {

	public final static int CITY_NUMBER = GA_TSP.CITY_NUMBER;
	public static int[][] MAP = GA_TSP.MAP;
	int gene[] = new int[CITY_NUMBER];
	int value;
	public Chromosome(int[] gene) {
		this.gene = gene.clone();
		calValue();
	}
	public Chromosome() {
		calValue();
	}
	private void calValue(){
		value = 0;
		for (int i = 1;i < CITY_NUMBER; i++){
			value += MAP[gene[i-1]][gene[i]];
		}
		
	}
	
	
}
