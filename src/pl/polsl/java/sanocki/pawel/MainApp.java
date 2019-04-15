/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.java.sanocki.pawel;

import java.io.IOException;
import java.util.InputMismatchException;
import pl.polsl.java.sanocki.pawel.model.Model;
import pl.polsl.java.sanocki.pawel.model.MyException;
import pl.polsl.java.sanocki.pawel.view.View;

/**
 * Main class of the program, controller
 * 
 * @author Paweł Sanocki
 * @version 2.0
 */
public class MainApp {
    /**
     * Function setting the order of operations in the program
     * @param args arguments given by the user in when launching the program, number of floors to be calculated and given
     */
    public static void main(String args[]){
        /*
         * keeps the information about user input
         */
        int choice;
        /*
         * generates the pascal triangle
         */
        Model model = new Model();
        /*
         * for I/O operations
         */
        View view = new View();
        try{
            if (args.length == 0){
                view.showOptions();
                choice = view.readInt();
            }else{
                choice = Integer.parseInt(args[0]);
            }
            model.generateParentNodes(choice);
            view.print(model.getTriangle().toString());
            model.generateBinomialCoef(choice);
            view.print(model.getTriangle().toString());
            view.print("Binomial coef time: " + model.getBinomialCoefTime()/1000 + " ms");
            view.print("Parent nodes time: " + model.getParentNodesTime()/1000 + " ms");
        }catch(MyException e){
            e.printStackTrace();
            e.getMessage();
        }catch(IOException | InputMismatchException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            view.print("The end of the program :)");
        }
    }
}
