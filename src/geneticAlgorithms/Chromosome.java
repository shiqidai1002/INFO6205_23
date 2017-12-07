package geneticAlgorithms;
public class Chromosome {

	public final static int CITY_NUMBER = GA_TSP.CITY_NUMBER;
	public static int[][] MAP = GA_TSP.MAP;
	int gene[] = new int[CITY_NUMBER];
	int distance;
	public Chromosome(int[] gene) {
		this.gene = gene.clone();
		calDistance();
	}
	public Chromosome() {
		calDistance();


	}
	private void calDistance(){
		distance = 0;
		for (int i = 1;i < CITY_NUMBER; i++){
			distance += MAP[gene[i-1]][gene[i]];
		}
		
	}
	
	
}
