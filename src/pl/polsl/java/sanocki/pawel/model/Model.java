/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.java.sanocki.pawel.model;

import java.util.Vector;
import pl.polsl.java.sanocki.pawel.timer.Timer;

/**
 * Model generating the pascal triangle, and calculating time of executions
 * @author Paweł Sanocki
 * @version 2.0
 */
public class Model {
    /**
     * used to keep the time of execution of generating the pascal triangle with parent nodes method
     */
    private long timeParentNodes;
    /**
     * used to keep the time of execution of generating the pascal triangle with Newton's coefficients method
     */
    private long timeBinomialCoef;
    /**
     * keeps the pascal triangle created with one of generation methods
     */
    private StringBuilder pascalTriangle;
    /**
     * Constructor
     */
    public Model() {
        this.timeParentNodes = 0;
        this.timeBinomialCoef = 0;
    }
    /**
     * Method generating pascal triangle using parent nodes method
     * Saves the result in the object's atrribute pascalTriangle
     * @param n Number of rows to be generated
     * @return String with the triangle
     * @throws MyException when the demanded value of floors is lower or equal to zero
     */
    public String generateParentNodes(int n) throws MyException{
        if (n <= 0) throw new MyException();
        /*
         * building the pascal triangle
         */
        StringBuilder result = new StringBuilder();
        /*
         * object of class Timer used to measure time of execution of the generation
         */
        Timer timer = new Timer();
        timer.startTimer();
        Vector <Vector<Long>> vec = new Vector<>();
        vec.add(new Vector<Long>());
        vec.elementAt(0).add(1L);
        result.append("1\n");
        for (int i = 1; i < n; i++){
            vec.add(new Vector<Long>());
        }
        for (int i = 1; i < n; i++){
            vec.add(new Vector<Long>());
            for (int j = 0; j < i + 1; j++){
                if (j==0){
                    vec.elementAt(i).add(vec.elementAt(i-1).elementAt(j));
                    //arr[i][j] = arr[i - 1][j];
                }else if(j==i){
                    vec.elementAt(i).add(vec.elementAt(i-1).elementAt(j-1));
                }else{
                    vec.elementAt(i).add(vec.elementAt(i-1).elementAt(j)+ vec.elementAt(i-1).elementAt(j-1));
                    //arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                //result.append(arr[i][j]).append(" ");
                //result.append(vec.elementAt(i).elementAt(j)).append(" ");
            }
            //result.append("\n");
        }
        for (Vector<Long> i: vec){
            for (Long j: i){
                result.append(j).append(" ");
            }
            result.append("\n");
        }
        this.timeParentNodes = timer.stopTimer();
        pascalTriangle = result;
        return result.toString();
    }
    /**
     * Method for calculating the Newton's binomial using iterative method
     * @param n upper value
     * @param k lower value
     * @return the result of the operation
     */
    private long newtonBinomial(int n, int k){
        long result = 1L;
        for (int i = 1; i <= k; i++){
            result = result * (n-i+1) / i;
        }
        return result;
    }
    /**
     * Method generating pascal triangle using Newton's binomial coefficients method
     * Saves the result in the object's atrribute pascalTriangle
     * @param n Number of rows to be generated
     * @return String with the triangle
     * @throws MyException when the demanded value of floors is lower or equal to zero
     */
    public String generateBinomialCoef(int n) throws MyException{
        if (n <= 0) throw new MyException();
        /*
         * building the pascal triangle
         */
        StringBuilder result = new StringBuilder();
        /*
         * object of class Timer used to measure time of execution of the generation
         */
        Timer timer = new Timer();
        timer.startTimer();
        Vector <Vector<Long>> vec = new Vector<>();
        for (int i = 0; i < n; i++){
            vec.add(new Vector<Long>());
            for (int j = 0; j < i + 1; j++){
                //arr[i][j] = newtonBinomial(i, j);
                vec.elementAt(i).add(newtonBinomial(i, j));
                //result.append(arr[i][j]).append(" ");
                //result.append(vec.elementAt(i).elementAt(j)).append(" ");
            }
            //result.append("\n");
        }
        
        for (Vector<Long> i: vec){
            for (Long j: i){
                result.append(j).append(" ");
            }
            result.append("\n");
        }
        
        this.timeBinomialCoef = timer.stopTimer();
        pascalTriangle = result;
        return (result.toString());
    }
    /**
     * Method returns the pascalTriangle as a StringBuilder object
     * Works only after any method that generates the pascal triangle, otherwise returns blank StringBuilder
     * @return pascalTriangle
     */
    public StringBuilder getTriangle(){
        return this.pascalTriangle;
    }
    /**
     * Method to access time of generating the pascal triangle using Newton's binomial coefficients method
     * Works only after any method that generates the pascal triangle, otherwise returns 0
     * @return time spent on generating the triangle using Newton's binomial coefficients method
     */
    public long getBinomialCoefTime(){
        return this.timeBinomialCoef;
    }
    /**
     * Method to access time of generating the pascal triangle using  parent nodes method
     * Works only after any method that generates the pascal triangle, otherwise returns 0
     * @return time spent on generating the triangle using  parent nodes method
     */
    public long getParentNodesTime(){
        return this.timeParentNodes;
    }
}
