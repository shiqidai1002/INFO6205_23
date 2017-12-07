package geneticAlgorithms;

import java.util.ArrayList;
import java.util.Random;

public class GA_TSP {

	public static final int CITY_NUMBER = 10;
	public static final int MAX_GENERATION = 100;
	public static final int MAX_POPULATION = 100;
	public static final int MAX_DISTANCE = 30000;
	public static final double MUTATION_POSSIBILITY = 0.01;
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
    private static Chromosome[] copulation(Chromosome a,Chromosome b){


        Random random = new Random();
        int sp1 = random.nextInt(CITY_NUMBER);       //start of chromosome fragment
        int sp2 = random.nextInt(CITY_NUMBER);       //end of chromosome fragment
        if (sp1 > sp2) {
            int t = sp1;
            sp1 = sp2;
            sp2 = t;
        }
        return copulation(a,b,sp1,sp2);
    }

    private static Chromosome[] copulation(Chromosome a,Chromosome b, int sp1, int sp2){
       Chromosome[] decendant = new Chromosome[2];

       int[] gene_1 = new int[CITY_NUMBER];        //first son
       int[] gene_2 = new int[CITY_NUMBER];        //second son

       //Copulation
        boolean[] hash_1 = new boolean[CITY_NUMBER];      //record used gene(visited city)
        boolean[] hash_2 = new boolean[CITY_NUMBER];
        for (int i = sp1; i<= sp2; i++){
            gene_1[i] = a.gene[i];
            hash_1[a.gene[i]] = true;
            gene_2[i] = b.gene[i];
            hash_2[b.gene[i]] = true;
        }
        int ka = 0;
        int kb = 0;
        for (int i = 0; i < CITY_NUMBER; i++){
            if ((i >= sp1)&&(i <= sp2)) continue;

            while (hash_1[b.gene[kb]]) kb++;
            gene_1[i] = b.gene[kb];
            hash_1[b.gene[kb]] = true;

            while (hash_2[a.gene[ka]]) ka++;
            gene_2[i] = a.gene[ka];
            hash_2[a.gene[ka]] = true;

        }

        //Mutation

        //return
        decendant[0] = new Chromosome(gene_1);
        decendant[1] = new Chromosome(gene_2);
        return decendant;
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
