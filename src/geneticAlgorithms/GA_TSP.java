package geneticAlgorithms;

import java.util.*;

public class GA_TSP {
    public static final int MAX_DISTANCE = 30000;
    public static boolean DEFAULT = true;

    public static int CITY_NUMBER = 20;
    public static int MAX_GENERATION = 100;
    public static int MAX_POPULATION = 400;
    public static double MUTATION_POSSIBILITY = 0.1;

    public int[][] map = new int[CITY_NUMBER][CITY_NUMBER];
    public ArrayList<Chromosome> population = new ArrayList<Chromosome>();
    public int age;
    private static Random random = new Random();

    private void getRandomMap(int CITY_NUMBER) {
        map = new int[CITY_NUMBER][CITY_NUMBER];

        //Create a random map
        for (int i = 0; i < CITY_NUMBER; i++) {
            for (int j = 0; j < CITY_NUMBER; j++) {
                if (i < j) {
                    map[i][j] = (int) (Math.random() * MAX_DISTANCE);
                    map[j][i] = map[i][j];
                }
            }
        }
    }

    private void initialize() {
        //Create first generation
        for (int i = 0; i < MAX_POPULATION; i++) {
            population.add(new Chromosome(map));
        }

        age = 0;
    }

    public void reproduce() {

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

    public void eliminate() {
        // sorting
        Collections.sort(population); //ascending order

        // remove by chance
        double deadChance;
        double deadmen = 0;
        while (deadmen < MAX_POPULATION) {
            ArrayList<Chromosome> deadList = new ArrayList<Chromosome>();
            for (int i = population.size() - 1; i >= 0; i--) {
                if (deadmen < MAX_POPULATION) {
                    deadChance = (i + 1.0) / population.size();
                    if (theDeath(deadChance)) {
                        deadList.add(population.get(i));
                        deadmen++;
                    }
                } else {
                    break;
                }
            }
            //System.out.println("deadList number: " + deadList.size());
            for (Chromosome dying : deadList) {
                population.remove(dying);
            }
        }
    }

    /*
    Constructor

    Default parameter, random map
     */
    public GA_TSP() {
        getRandomMap(CITY_NUMBER);
        initialize();
    }

    /*
    Constructor

    Given parameter, random map
     */
    public GA_TSP(int cityNumber, int maxGe, int maxPo, double mutationPo) {
        CITY_NUMBER = cityNumber;
        MAX_POPULATION = maxPo;
        MAX_GENERATION = maxGe;
        MUTATION_POSSIBILITY = mutationPo;
        getRandomMap(CITY_NUMBER);
        initialize();
    }

    /*
    Constructor

    Given parameter, given map
    */
    public GA_TSP(int cityNumber, int maxGe, int maxPo, double mutationPo, int[][] map) {
        CITY_NUMBER = cityNumber;
        MAX_POPULATION = maxPo;
        MAX_GENERATION = maxGe;
        MUTATION_POSSIBILITY = mutationPo;
        this.map = map.clone();
        initialize();
    }


    public static void main(String[] args) {
        if (DEFAULT) {
            GA_TSP ga = new GA_TSP();
            for (int i = 0; i < MAX_GENERATION; i++) {
                ga.reproduce();
                ga.eliminate();
                ga.age++;
                System.out.println("Generation #" + (i + 1) + ":\tShortest distance= " + ga.population.get(0).distance
                        + "\tcurrent population size=" + ga.population.size());
            }

        }
    }
}
