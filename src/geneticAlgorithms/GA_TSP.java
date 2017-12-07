package geneticAlgorithms;

import java.util.ArrayList;

public class GA_TSP {

	public static final int CITY_NUMBER = 10;
	public static final int MAX_GENERATION = 100;
	public static final int MAX_POPULATION = 100;
	public static final int MAX_DISTANCE = 30000;
	public static int[][] MAP = new int[CITY_NUMBER][CITY_NUMBER];
	public static ArrayList<Chromosome> Population = new ArrayList<Chromosome>();
	public static int age;
    private static void initialization() {
        //Create a random map
        for (int i = 0; i < CITY_NUMBER; i++){
            for (int j = 0; j < CITY_NUMBER; j++){
               if (i < j){
                   MAP[i][j] = (int)(Math.random()*MAX_DISTANCE);
                   MAP[j][i] = MAP[i][j];
               }
            }
        }

        //Create first generation
        for (int i = 0; i < MAX_POPULATION; i++){
            Population.add(new Chromosome());
        }

        age = 0;


    }

    private static void reproduction() {

    }

    private static void elimination() {
        //TODO

    }



    public static void main(){
		initialization();
		for (int i = 0;i < MAX_GENERATION;i++){
			reproduction();
            elimination();
            age++;
		}
	}





    //
	
}
