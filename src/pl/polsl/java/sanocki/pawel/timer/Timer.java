/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.java.sanocki.pawel.timer;

/**
 * Class for measuring the difference of time between two moments
 * @author Paweł Sanocki
 * @version 2.0
 */
public class Timer {
    /**
     * storing the time of starting the timer
     */
    private long timeStart;
    /**
     * saving the moment when timer has been started
     */
    public void startTimer(){
        timeStart = System.nanoTime();
    }
    /**
     * stops the timer
     * @return time in nanoseconds from starting the timer to stopping it
     */
    public long stopTimer(){
        return System.nanoTime() - this.timeStart;
    }
}
