/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.java.sanocki.pawel.view;

import java.io.IOException;
import java.util.Scanner;

/**
 * View handles I/O
 * @author Paweł Sanocki
 * @version 2.0
 */
public class View {
    /**
     * Scanner used to tahe the users input
     */
    private final Scanner scn = new Scanner(System.in);
    /**
     * Method that takes input integer from the user
     * @return value of input as the integer
     * @throws IOException when value is not an integer
     */
    public int readInt() throws IOException{
        return scn.nextInt();
    }
    /**
     * Method that prints the string on the standard output
     * @param str String to be displayed
     */
    public void print(String str){
        System.out.println(str);
    }
    /**
     * Menu that asks the user for inputs
     */
    public void showOptions (){
        System.out.println("How many rows should be printed?");
    }
    
}
