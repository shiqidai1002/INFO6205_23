# INFO6205_23
### Quick look: ###
NEU_COE_INFO 6205 TSP implementing with genetic algorithm

### Team 23: ###
**Member:**  
Shiqi Dai : 001819581  
Wenqi Cui : 001819564  
**Advisor:**  
Dr. Robin Hillyard

### Question Discription: ###
The travelling salesman problem (TSP) asks the following question: "Given a list of cities and the distances between each pair of cities, what is the shortest possible route that visits each city exactly once and returns to the origin city?" It is an NP-hard problem in combinatorial optimization, important in operations research and theoretical computer science.

### Program Structure ###

**Quick Look**
- src
   - GA_TSP.java     
   - Chromosome.java
- test
   - GA_TSPTest.java
   - ChromosomeTest.java  

**Detailed Structure**  
- GA_TSP.java

![](https://github.com/shiqidai1002/INFO6205_23/blob/master/img/GA_TSP_structure.png)  
- Chromosome.java

![](https://github.com/shiqidai1002/INFO6205_23/blob/master/img/Chromosome_structure.png)

### Design of Chromosome ###

**Field**  

`public static final int CITY_NUMBER = GA_TSP.CITY_NUMBER;`    
`public static int[][] MAP;`   
`public int gene[];`    
`public int distance;`  

**Design of gene**

- Gene is an int array whose length is equal to `CITY_NUMBER`.  
    - `gene = new int[CITY_NUMBER];`
    
- Each index stores an int which represents a city

- Index from 0 to `CITY_NUMBER - 1`, representing the order of salesman's visiting.

- The value of every gene's first index is 0, which means the salesman starts from city 0.  
    - It is represented as: 
     
        > for (int **i = 1**; i < CITY_NUMBER; i++) {  
        gene[i] = i;  
         }
          
        i starts from 1, thus index 0 will automatically be 0.

**Gene expression**

The gene of each chromosome is expressed by the distance.  

`calDistance()` will sum up all the distances between every neighbor indices. Then add the distance between the last index and 0, which means the salesman returns to the origin.

By the way, the distance is used as key when chromosome is compared.

### User guide ###

**Default Settings**  

If a user doesn't set any parameters, the program will use our default settings  
Default values for each variables are as coded below.  
You can also find them in the field of GA_TSP.java.  

`public static int CITY_NUMBER = 20;`  
`public static int MAX_GENERATION = 100;`  
`public static int MAX_POPULATION = 400;`  
`public static double MUTATION_POSSIBILITY = 0.1;`

By this way (default), the program will call the default constructor `GA_TSP()`, using default values and a random map.

**Customized Settings**  

A user can also customize their own codintion by using the other two constructors:  
- given parameters, random map  
`GA_TSP(int cityNumber, int maxGe, int maxPo, double mutationPo)`  
- given parameters, given map  
`GA_TSP(int cityNumber, int maxGe, int maxPo, double mutationPo, int[][] map)`

**How it works**

   1. set a map 
        - random / given  
   2. `initialize()`
        - based on map generate the 1st generation of population
   3. loop to generate, for each:
        - `reproduce()`
            - randomize `int[] order`
            - `copulate()` each 2 individuals
                - `mutation()` happened by `MUTATION_POSSIBILITY`
            - finally got 2x `MAX_POPULATION`
        - `eliminate()` 
            - sort: according to ascending order
                - `Collections.sort(population);`
            - cull by chance
                - the closer to the end of sorting, the more likely to deadth 
  


**Output**

The shortest distance of each generation will be printed onto console.  
The printed current population is to help user to make sure the stability of the population.

Output is like this below:

    Generation #1:  Shortest distance= 149606  current population size=400
    Generation #2:  Shortest distance= 149606  current population size=400
    Generation #3:  Shortest distance= 149606  current population size=400
    Generation #4:  Shortest distance= 149606  current population size=400
    Generation #5:  Shortest distance= 149606  current population size=400
    .
    .
    .
    Generation #96:  Shortest distance= 48693  current population size=400
    Generation #97:  Shortest distance= 48693  current population size=400
    Generation #98:  Shortest distance= 48693  current population size=400
    Generation #99:  Shortest distance= 48693  current population size=400
    Generation #100: Shortest distance= 48693  current population size=400
    


### Unit Test ###

**Test Content**

>For detailed content of each test method, please check code files

- GA_TSPTest
    - `testCopulateForASSp1Sp2()`
    - `testEliminate()`
    - `testInitialize()`
    - `testReproduce()`
- ChromosomeTest
    - `testCalDistance()`
    - `testComparableTo()`
    - `testEquals()`
    - `testMutation()`
    

**Screen Shots**

>All the test cases have been passed.

- GA_TSPTest

![](https://github.com/shiqidai1002/INFO6205_23/blob/master/img/GA_TSPTest.jpg)

- ChromosomeTest

![](https://github.com/shiqidai1002/INFO6205_23/blob/master/img/ChromosomeTest.jpg)
