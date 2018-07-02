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

package local.example.draft.controller;

import local.example.draft.service.PseudoRandomNumberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author paolo mococci
 */

@RestController
@RequestMapping(value = "/api")
public class PseudoRandomNumberController {
    
    private final PseudoRandomNumberService service;

    public PseudoRandomNumberController() {
        this.service = new PseudoRandomNumberService();
    }
    
    @RequestMapping(path = "/prn/double", 
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public double doubleResponse() 
            throws Exception {
        return service.getPseudoRandomDoubleNumber();
    }
    
    @RequestMapping(path = "/prn/long", 
            method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public long longResponse() 
            throws Exception {
        return service.getPseudoRandomLongNumber();
    }
    
    @RequestMapping(path = "/str/hex", 
            method = RequestMethod.GET, 
            produces = "text/plain")
    public String exadecimalStringResponse() 
            throws Exception {
        return service.getPseudoRandomHexadecimalString();
    }
}
