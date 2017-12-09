package test.geneticAlgorithms; 

import geneticAlgorithms.Chromosome;
import geneticAlgorithms.GA_TSP;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static junit.framework.TestCase.*;

public class GA_TSPTest {
    GA_TSP ga_tsp;
@Before

public void before() throws Exception {
    ga_tsp = new GA_TSP();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: main() 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: initialization() 
* 
*/ 
@Test
public void testInitialization() throws Exception { 

    assertEquals(ga_tsp.population.size(), GA_TSP.MAX_POPULATION);
/* 
try { 
   Method method = GA_TSP.getClass().getMethod("initialization"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: reproduction() 
* 
*/ 
@Test
public void testReproduction() throws Exception { 

    ga_tsp.reproduce();
    assertEquals(ga_tsp.population.size(), GA_TSP.MAX_POPULATION * 2);
/* 
try { 
   Method method = GA_TSP.getClass().getMethod("reproduction"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: copulation(Chromosome a, Chromosome b) 
* 
*/ 
@Test
public void testCopulationForAB() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = GA_TSP.getClass().getMethod("copulation", Chromosome.class, Chromosome.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: copulation(Chromosome a, Chromosome b, int sp1, int sp2) 
* 
*/ 
@Test
public void testCopulationForABSp1Sp2() throws Exception { 
    int[] ga = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
    int[] gb = {0,1,2,3,4,5,6,7,9,8,10,11,12,13,14,15,16,17,18,19};
    Chromosome a = new Chromosome(ga);
    Chromosome b = new Chromosome(gb);
    Chromosome[] ans = new Chromosome[2];
    ans[0] = new Chromosome(ga);
    ans[1] = new Chromosome(gb);
    assertEquals(ans[0],GA_TSP.copulate(a,b,7,9)[0]);
    assertEquals(ans[1],GA_TSP.copulate(a,b,7,9)[1]);
    assertEquals(ans[1],GA_TSP.copulate(a,b,0,7)[0]);
    assertEquals(ans[0],GA_TSP.copulate(a,b,0,7)[1]);

/* 
try { 
   Method method = GA_TSP.getClass().getMethod("copulation", Chromosome.class, Chromosome.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: elimination() 
* 
*/ 
@Test
public void testElimination() throws Exception { 

    ga_tsp.reproduce();
    ga_tsp.eliminate();
    assertEquals(ga_tsp.population.size(),GA_TSP.MAX_POPULATION);
/* 
try { 
   Method method = GA_TSP.getClass().getMethod("elimination"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
