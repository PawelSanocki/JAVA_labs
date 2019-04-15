/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.java.sanocki.pawel.model;

/**
 * Thrown when users demands the result with negative or zero number of floors
 * @author Paweł Sanocki
 * @version 1.0
 */
public class MyException extends Exception {
    public MyException(){
        super("My message! Number of floors cannot be equal or less than 0!");
    }
}
