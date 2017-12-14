/*
 * Copyright 2017 Mohamed Nagy Mostafa Mohamed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
