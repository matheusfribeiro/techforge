package com.techforge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techforge.models.Category;
import com.techforge.models.Status;
import com.techforge.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;MODE=MYSQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE",
        "spring.datasource.driverClassName=org.h2.Driver",
        "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.flyway.enabled=false"
})
public class CategoryControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryRepository categoryRepo;

    private Integer createdId;

    @BeforeEach
    void setUp() throws Exception {

        Category testCategory = new Category(
                "Testing Category",
                "testing-cat",
                "Short desc for testing",
                "Study guide text",
                Status.ACTIVE,
                5,
                "/icons/test.png",
                "#ABCDEF"
        );

        Category savedCategory = categoryRepo.save(testCategory);

        createdId = savedCategory.getId();


    }

    @Test
    void testCreateCategory() throws Exception {
        // json was bugging because of code conflict
        String createJson = """
                {\
                "name": "New Category",\
                "code": "testing-cat-new",\
                "shortDescription": "Desc",\
                "studyGuide": "Guide",\
                "status": "ACTIVE",\
                "order": 1,\
                "iconPath": "/icons/new.png",\
                "htmlColorCode": "#123456"\
                }""";

        mockMvc.perform(post("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.code").value("testing-cat-new"))
                .andExpect(jsonPath("$.name").value("New Category"));
    }

    @Test
    void testGetAllCategories() throws Exception {
        mockMvc.perform(get("/api/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].code").value("testing-cat"))
                .andExpect(jsonPath("$[0].name").value("Testing Category"));
    }

    @Test
    void testGetCategoryById() throws Exception {
        mockMvc.perform(get("/api/categories/" + createdId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("testing-cat"))
                .andExpect(jsonPath("$.name").value("Testing Category"));    }

    @Test
    void testUpdateCategory() throws Exception {
        Category existingCategory = categoryRepo.findById(createdId).orElseThrow();
        existingCategory.setName("Updated Category");
        existingCategory.setOrder(7);
        ObjectMapper jackson = new ObjectMapper();
        String updateJson = jackson.writeValueAsString(existingCategory);

        mockMvc.perform(put("/api/categories/" + createdId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("testing-cat"))
                .andExpect(jsonPath("$.name").value("Updated Category"))
                .andExpect(jsonPath("$.order").value(7));
    }

    @Test
    void testDeleteCategory() throws Exception {
        mockMvc.perform(delete("/api/categories/" + createdId))
                .andDo(print())
                .andExpect(status().isNoContent());

        assertTrue(categoryRepo.findById(createdId).isEmpty());
    }

    @Test
    void testNonExistingCategoryReturnsNotFound() throws Exception {
        mockMvc.perform(delete("/api/categories/9999"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
