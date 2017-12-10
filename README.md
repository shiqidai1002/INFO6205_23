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