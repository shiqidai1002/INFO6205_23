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
- src
   - GA_TSP.java     
   - Chromosome.java
- test
   - GA_TSPTest.java
   - ChromosomeTest.java

![](https://github.com/shiqidai1002/INFO6205_23/blob/master/img/GA_TSP_structure.png)
![](https://github.com/shiqidai1002/INFO6205_23/blob/master/img/Chromosome_structure.png)

### User guide ###
default setting

`public static int CITY_NUMBER = 20;`  
`public static int MAX_GENERATION = 100;`  
`public static int MAX_POPULATION = 400;`  
`public static double MUTATION_POSSIBILITY = 0.1;`