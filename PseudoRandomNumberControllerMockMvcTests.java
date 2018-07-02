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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author paolo mococci
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PseudoRandomNumberControllerMockMvcTests {
    
    private static final String PATH_DOUBLE = "/api/prn/double";
    private static final String PATH_LONG = "/api/prn/long";
    private static final String PATH_HEX_STR = "/api/str/hex";
    private MockMvc mockMvc;
    
    @Autowired
    WebApplicationContext webAppCtx;
    
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppCtx).build();
    }
    
    @Test
    public void testRestControllerDoubleStatusIsOk() 
            throws Exception {
        mockMvc.perform(get(PATH_DOUBLE))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testRestControllerDoubleContentType() 
            throws Exception {
        mockMvc.perform(get(PATH_DOUBLE))
                .andExpect(content()
                        .contentType("application/json;charset=UTF-8"));
    }
    
    @Test
    public void testRestControllerDoubleValueType() 
            throws Exception {
        mockMvc.perform(get(PATH_DOUBLE))
                .andExpect(jsonPath("$").isNumber());
    }
    
    @Test
    public void testRestControllerLongStatusIsOk() 
            throws Exception {
        mockMvc.perform(get(PATH_LONG))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testRestControllerLongContentType() 
            throws Exception {
        mockMvc.perform(get(PATH_LONG))
                .andExpect(content()
                        .contentType("application/json;charset=UTF-8"));
    }
    
    @Test
    public void testRestControllerLongValueType() 
            throws Exception {
        mockMvc.perform(get(PATH_LONG))
                .andExpect(jsonPath("$").isNumber());
    }
    
    @Test
    public void testRestControllerStringStatusIsOk() 
            throws Exception {
        mockMvc.perform(get(PATH_HEX_STR))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testRestControllerStringContentType() 
            throws Exception {
        mockMvc.perform(get(PATH_HEX_STR))
                .andExpect(content()
                        .contentType("text/plain;charset=UTF-8"));
    }
    
    @Test
    public void testRestControllerStringValueType() 
            throws Exception {
        mockMvc.perform(get(PATH_HEX_STR))
                .andExpect(jsonPath("$").isString());
    }
}
