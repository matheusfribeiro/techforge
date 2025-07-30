package com.techforge;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE",
        "spring.datasource.driverClassName=org.h2.Driver",
        "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.flyway.enabled=false"
})
public class CategoryControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private Integer createdId;
    private final String baseJson = "{"
            + "\"name\": \"Testing Category\","
            + "\"code\": \"testing-cat\","
            + "\"shortDescription\": \"Short desc for testing\","
            + "\"studyGuide\": \"Study guide text\","
            + "\"status\": \"ACTIVE\","
            + "\"order\": 5,"
            + "\"iconPath\": \"/icons/test.png\","
            + "\"htmlColorCode\": \"#ABCDEF\""
            + "}";

    @BeforeEach
    void setUp() throws Exception {
        MvcResult result = mockMvc.perform(post("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(baseJson))
                .andExpect(status().isCreated())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        createdId = JsonPath.read(json, "$.id");
    }

    @Test
    void testCreateCategory() throws Exception {
        // json was bugging because of code conflict
        String createJson = "{"
                + "\"name\": \"New Category\","
                + "\"code\": \"testing-cat-new\","
                + "\"shortDescription\": \"Desc\","
                + "\"studyGuide\": \"Guide\","
                + "\"status\": \"ACTIVE\","
                + "\"order\": 1,"
                + "\"iconPath\": \"/icons/new.png\","
                + "\"htmlColorCode\": \"#123456\""
                + "}";

        mockMvc.perform(post("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").value("New Category"));
    }

    @Test
    void testGetAllCategories() throws Exception {
        mockMvc.perform(get("/api/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code").value("testing-cat"));
    }

    @Test
    void testGetCategoryById() throws Exception {
        mockMvc.perform(get("/api/categories/" + createdId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.order").value(5));
    }

    @Test
    void testUpdateCategory() throws Exception {
        String updateJson = baseJson.replace("Testing Category", "Updated Category").replace("5", "7");
        mockMvc.perform(put("/api/categories/" + createdId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Category"))
                .andExpect(jsonPath("$.order").value(7));
    }

    @Test
    void testDeleteCategory() throws Exception {
        mockMvc.perform(delete("/api/categories/" + createdId))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetDeletedCategoryReturnsNotFound() throws Exception {
        mockMvc.perform(delete("/api/categories/" + createdId))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/api/categories/" + createdId))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
