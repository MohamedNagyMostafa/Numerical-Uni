/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program;

import javax.swing.JProgressBar;

/**
 *
 * @author Mohamed Nagy
 */
public class Progress {
    
    private final JProgressBar progressBar;
    private float progressBarIncreasing;
    
    public Progress(JProgressBar progressBar) {
        this.progressBar = progressBar;
        progressBarIncreasing = 0;
    }
    
    public synchronized void increaseBy(int value){
        progressBar.setValue(value);
        progressBarIncreasing += value;
    }
    
    public synchronized void clear(){
        progressBar.setValue(0);
        progressBarIncreasing = 0;
    }
    
    public synchronized void setIncreasingValue(float increasing){
        progressBarIncreasing = increasing;
    }
    
    public synchronized void increasingByOne(){
        progressBar.setValue(Math.round(progressBarIncreasing));
        progressBarIncreasing += progressBarIncreasing;
    }
}
