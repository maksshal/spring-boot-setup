package com.maksshal.spring.setup.rest;

import com.maksshal.spring.setup.db.entities.MsUser;
import com.maksshal.spring.setup.db.repositories.MsUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "test")
@AutoConfigureMockMvc
public class MsUserRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Before
    public void init() {

    }

    @Test
    @WithMockUser
    public void testExistingUser() throws Exception {
        mvc.perform(get("/rest/user?lastName=Shalak"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.lastName", is("Shalak")))
                .andExpect(jsonPath("$.firstName", is("Maksym")));
    }

    @Test
    @WithMockUser
    public void testMissingUser() throws Exception {
        mvc.perform(get("/rest/user?lastName=Bozhyk"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testUnauthorized() throws Exception {
        mvc.perform(get("/rest/user?lastName=Bozhyk"))
                .andExpect(status().isUnauthorized());
    }
}
