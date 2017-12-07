package geneticAlgorithms;

import java.util.Random;

public class Chromosome {

	public final static int CITY_NUMBER = GA_TSP.CITY_NUMBER;
	public static int[][] MAP = GA_TSP.MAP;
	public int gene[] ;
	public int distance;
	/*
	Construction
	Create by an array
	 */
	public Chromosome(int[] gene) {
		this.gene = gene.clone();
		calDistance();
	}
	/*
	Construction
	Create by random
	 */
	public Chromosome() {
		Random random = new Random();
		gene = new int[CITY_NUMBER];
		for (int i = 1; i < CITY_NUMBER; i++){
			gene[i] = i;
		}
		int j = 0;
		int t = 0;
		for (int i = CITY_NUMBER-1; i > 0; i--){
			j = random.nextInt(i)+1;
			t = gene[i];
			gene[i] = gene [j];
			gene[j] = t;
		}
		calDistance();


	}
	/*
	Calculate distance
	 */
	private void calDistance(){
		distance = 0;
		for (int i = 1;i < CITY_NUMBER; i++){
			distance += MAP[gene[i-1]][gene[i]];
		}
		distance += MAP[gene[CITY_NUMBER-1]][0];
	}
	
	
}
