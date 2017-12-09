package test.geneticAlgorithms;

import geneticAlgorithms.Chromosome;
import geneticAlgorithms.GA_TSP;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Chromosome Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 9, 2017</pre>
 */
public class ChromosomeTest {
    GA_TSP ga_tsp = new GA_TSP();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: equals(Object o)
     */
    @Test
    public void testEquals() throws Exception {
        int[] gene1 = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 1};
        int[] gene2 = {0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 2, 19};
        Chromosome cm1 = new Chromosome(gene1);
        Chromosome cm2 = new Chromosome(gene2);
        assertFalse(cm1.equals(cm2));
        Chromosome cm3 = new Chromosome(gene1);
        assertTrue(cm1.equals(cm3));
    }

    /**
     * Method: compareTo(Object o)
     */
    @Test
    public void testCompareTo() throws Exception {

        int[] gene1 = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 1};
        int[] gene2 = {0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 2, 19};
        Chromosome cm1 = new Chromosome(gene1);
        Chromosome cm2 = new Chromosome(gene2);
        int dis1 = cm1.distance;
        int dis2 = cm2.distance;
        int ans = dis1 - dis2;
        assertEquals(Math.signum(ans), Math.signum(cm1.compareTo(cm2)));

    }

    /**
     * Method: mutation()
     */
    @Test
    public void testMutation() throws Exception {
        int[] gene1 = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 1};
        int[] gene2 = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 1};
        Chromosome cm1 = new Chromosome(gene1);
        Chromosome cm2 = new Chromosome(gene2);
        assertTrue(cm1.equals(cm2));
        cm2.mutation();
        assertFalse(cm1.equals(cm2));
    }


    /**
     * Method: calDistance()
     */
    @Test
    public void testCalDistance() throws Exception {
        int[] gene = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 1};
        Chromosome cm = new Chromosome(gene);
        int currentDistance = 0;
        for (int i = 1; i < cm.CITY_NUMBER; i++) {
            currentDistance += cm.MAP[i - 1][i];
        }
        currentDistance += cm.MAP[cm.CITY_NUMBER - 1][0];
        assertEquals(currentDistance, cm.distance);
/* 
try { 
   Method method = Chromosome.getClass().getMethod("calDistance"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
