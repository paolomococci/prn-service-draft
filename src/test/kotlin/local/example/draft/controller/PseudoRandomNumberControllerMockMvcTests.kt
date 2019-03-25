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

package local.example.draft.controller

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@SpringBootTest
class PseudoRandomNumberControllerMockMvcTests {
    private var mockMvc: MockMvc? = null

    @Autowired
    internal var webAppCtx: WebApplicationContext? = null

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppCtx!!).build()
    }

    @Test
    @Throws(Exception::class)
    fun testRestControllerDoubleStatusIsOk() {
        mockMvc!!.perform(get(PATH_DOUBLE))
                .andExpect(status().isOk)
    }

    @Test
    @Throws(Exception::class)
    fun testRestControllerDoubleContentType() {
        mockMvc!!.perform(get(PATH_DOUBLE))
                .andExpect(content()
                        .contentType("application/json;charset=UTF-8"))
    }

    @Test
    @Throws(Exception::class)
    fun testRestControllerDoubleValueType() {
        mockMvc!!.perform(get(PATH_DOUBLE))
                .andExpect(jsonPath("$").isNumber)
    }

    @Test
    @Throws(Exception::class)
    fun testRestControllerLongStatusIsOk() {
        mockMvc!!.perform(get(PATH_LONG))
                .andExpect(status().isOk)
    }

    @Test
    @Throws(Exception::class)
    fun testRestControllerLongContentType() {
        mockMvc!!.perform(get(PATH_LONG))
                .andExpect(content()
                        .contentType("application/json;charset=UTF-8"))
    }

    @Test
    @Throws(Exception::class)
    fun testRestControllerLongValueType() {
        mockMvc!!.perform(get(PATH_LONG))
                .andExpect(jsonPath("$").isNumber)
    }

    @Test
    @Throws(Exception::class)
    fun testRestControllerStringStatusIsOk() {
        mockMvc!!.perform(get(PATH_HEX_STR))
                .andExpect(status().isOk)
    }

    @Test
    @Throws(Exception::class)
    fun testRestControllerStringContentType() {
        mockMvc!!.perform(get(PATH_HEX_STR))
                .andExpect(content()
                        .contentType("text/plain;charset=UTF-8"))
    }

    @Test
    @Throws(Exception::class)
    fun testRestControllerStringValueType() {
        mockMvc!!.perform(get(PATH_HEX_STR))
                .andExpect(jsonPath("$").isString)
    }

    companion object {
        private const val PATH_DOUBLE = "/api/prn/double"
        private const val PATH_LONG = "/api/prn/long"
        private const val PATH_HEX_STR = "/api/str/hex"
    }
}
