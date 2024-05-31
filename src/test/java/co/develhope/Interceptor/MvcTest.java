package co.develhope.Interceptor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MvcTest {

    @Test
    void contextLoads() {
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    void successfulOperation_test() throws Exception {

        this.mockMvc.perform(get("/calculator/division?dividend=10&divisor=2"))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(content().string("5"));
    }

    @DirtiesContext
    @Test
    void notSuccessfulOperation_test() throws Exception {

        this.mockMvc.perform(get("/calculator/division?dividend=10&divisor=0"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @DirtiesContext
    @Test
    void loadAllErrors_test() throws Exception {

        this.mockMvc.perform(get("/calculator/division?dividend=10&divisor=0"))
                .andDo(print());


        this.mockMvc.perform(get("/v1/errors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].statusCode", is(400)));
    }

}
