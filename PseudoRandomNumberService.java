/**
 * 
 * Copyright 2018 paolo mococci
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package local.example.draft.service;

import org.apache.commons.math3.random.RandomDataGenerator;

/**
 *
 * @author paolo mococci
 */

public class PseudoRandomNumberService {
    
    private final RandomDataGenerator rdg;

    public PseudoRandomNumberService() {
        super();
        rdg = new RandomDataGenerator();
    }
    
    public double getPseudoRandomDoubleNumber() {
        return rdg.nextUniform(0.0, 1.0, true);
    }
    
    public long getPseudoRandomLongNumber() {
        return rdg.nextLong(0, Long.MAX_VALUE);
    }
    
    public String getPseudoRandomHexadecimalString() {
        return rdg.nextHexString(128);
    }
}
