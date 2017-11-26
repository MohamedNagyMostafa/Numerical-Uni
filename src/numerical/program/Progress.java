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
    private double progressBarIncreasing;
    
    public Progress(JProgressBar progressBar) {
        this.progressBar = progressBar;
        progressBarIncreasing = 0;
    }
    
    public void increaseBy(int value){
        progressBar.setValue(value);
        progressBarIncreasing += value;
    }
    
    public void clear(){
        progressBar.setValue(0);
        progressBarIncreasing = 0;
    }
    
    public void setIncreasingValue(double increasing){
        progressBarIncreasing = increasing;
    }
    
    public void increasingByOne(){
        progressBarIncreasing += progressBarIncreasing;
        progressBar.setValue(Integer.valueOf(progressBarIncreasing));
    }
}
