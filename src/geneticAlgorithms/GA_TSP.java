package geneticAlgorithms;

import java.util.*;

public class GA_TSP {
    public static boolean RANDOM_MAP = true;
    public static final int CITY_NUMBER = 50;
    public static final int MAX_GENERATION = 150;
    public static final int MAX_POPULATION = 500;
    public static final int MAX_DISTANCE = 30000;
    public static final double MUTATION_POSSIBILITY = 0.01;
    public static int[][] MAP = new int[CITY_NUMBER][CITY_NUMBER];
    public static ArrayList<Chromosome> population = new ArrayList<Chromosome>();
    public static int age;
    private static Random random = new Random();

    private static void initialize() {
        //Create a random map
        for (int i = 0; i < CITY_NUMBER; i++) {
            for (int j = 0; j < CITY_NUMBER; j++) {
                if (i < j) {
                    MAP[i][j] = (int) (Math.random() * MAX_DISTANCE);
                    MAP[j][i] = MAP[i][j];
                }
            }
        }

        //Create first generation
        for (int i = 0; i < MAX_POPULATION; i++) {
            population.add(new Chromosome());
        }

        age = 0;

    }

    private static void reproduce() {

        //Selection
        int[] order = new int[MAX_POPULATION];
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }
        int t = 0;
        int j = 0;
        for (int i = MAX_POPULATION - 1; i > 0; i--) {
            j = random.nextInt(i + 1);
            t = order[i];
            order[i] = order[j];
            order[j] = t;
        }

        //Reproduction
        for (int i = 0; i < MAX_POPULATION - 1; i += 2) {
            population.addAll(Arrays.asList(copulate(population.get(order[i]), population.get(order[i + 1]))));
        }


    }

    private static Chromosome[] copulate(Chromosome a, Chromosome b) {


        int sp1 = random.nextInt(CITY_NUMBER);       //start of chromosome fragment
        int sp2 = random.nextInt(CITY_NUMBER);       //end of chromosome fragment
        if (sp1 > sp2) {
            int t = sp1;
            sp1 = sp2;
            sp2 = t;
        }
        Chromosome[] descendant = copulate(a, b, sp1, sp2);
        for (Chromosome d : descendant) {
            if (Math.random() < MUTATION_POSSIBILITY) d.mutation();
        }
        return descendant;
    }

    public static Chromosome[] copulate(Chromosome a, Chromosome b, int sp1, int sp2) {
        Chromosome[] descendant = new Chromosome[2];

        int[] gene_1 = new int[CITY_NUMBER];        //first child
        int[] gene_2 = new int[CITY_NUMBER];        //second child

        //copulate
        boolean[] hash_1 = new boolean[CITY_NUMBER];      //record used gene(visited city)
        boolean[] hash_2 = new boolean[CITY_NUMBER];
        for (int i = sp1; i <= sp2; i++) {
            gene_1[i] = a.gene[i];
            hash_1[a.gene[i]] = true;
            gene_2[i] = b.gene[i];
            hash_2[b.gene[i]] = true;
        }
        int ka = 0;
        int kb = 0;
        for (int i = 0; i < CITY_NUMBER; i++) {
            if ((i >= sp1) && (i <= sp2)) continue;

            while (hash_1[b.gene[kb]]) kb++;
            gene_1[i] = b.gene[kb];
            hash_1[b.gene[kb]] = true;

            while (hash_2[a.gene[ka]]) ka++;
            gene_2[i] = a.gene[ka];
            hash_2[a.gene[ka]] = true;

        }

        //return
        descendant[0] = new Chromosome(gene_1);
        descendant[1] = new Chromosome(gene_2);
        return descendant;
    }


    private static boolean theDeath(double percentage) {
        percentage *= 1000;
        return random.nextInt(1000) < percentage;
    }

    private static void eliminate() {
        // sorting
        Collections.sort(population); //ascending order

        // remove by chance
        double deadChance;
        ArrayList<Chromosome> deadList = new ArrayList<Chromosome>();
        while (deadList.size() < 100) {
            for (int i = population.size() - 1; i >= 0; i--) {
                if (deadList.size() < 100) {
                    deadChance = (i + 1.0) / population.size();
                    if (theDeath(deadChance)) {
                        deadList.add(population.get(i));
                    }
                } else {
                    break;
                }
            }
            for (Chromosome dying : deadList) {
                population.remove(dying);
            }
        }
    }


    public static void main(String[] args) {
        initialize();
        for (int i = 0; i < MAX_GENERATION; i++) {
            reproduce();
            eliminate();
            age++;
            System.out.println(population.get(0).toString());
        }

//        for (int i = 1; i < 100; i++){
//            System.out.println(population.get(i).toString());
//        }
    }

}
