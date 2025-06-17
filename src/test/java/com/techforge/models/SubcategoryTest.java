package com.techforge.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubcategoryTest {
    public static Subcategory validSubcategory() {
        return new Subcategory(
                1,
                "Programming",
                "programming",
                null,
                null,
                Status.INACTIVE,
                1,
                CategoryTest.validCategory()
        );
    }

    @Test
    void createSubcategoryShouldPass() {
        assertDoesNotThrow(() -> {
            validSubcategory();
        });
    }

    @Test
    void nameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Subcategory(
                        1,
                        null,
                        "code",
                        null,
                        null,
                        Status.ACTIVE,
                        1,
                        CategoryTest.validCategory()
                )
        );
    }

    @Test
    void nameCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new Subcategory(
                        1,
                        "",
                        "code",
                        null,
                        null,
                        Status.ACTIVE,
                        1,
                        CategoryTest.validCategory()
                )
        );
    }

    @Test
    void nameCannotBeBlank() {
        assertThrows(IllegalArgumentException.class, () ->
                new Subcategory(
                        1,
                        " ",
                        "code",
                        null,
                        null,
                        Status.ACTIVE,
                        1,
                        CategoryTest.validCategory()
                )
        );
    }

    @Test
    void codeCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Subcategory(
                        1,
                        "Name",
                        null,
                        null,
                        null,
                        Status.ACTIVE,
                        1,
                        CategoryTest.validCategory()
                )
        );
    }


    @Test
    void codeCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new Subcategory(
                        1,
                        "Name",
                        "",
                        null,
                        null,
                        Status.ACTIVE,
                        1,
                        CategoryTest.validCategory()
                )
        );
    }

    @Test
    void codeMustMatchPattern() {
        assertThrows(IllegalArgumentException.class, () ->
                new Subcategory(
                        1,
                        "Name",
                        "Bad Code!",
                        null,
                        null,
                        Status.ACTIVE,
                        1,
                        CategoryTest.validCategory()
                )
        );
    }

    @Test
    void orderMustBeAtLeastOne() {
        assertThrows(IllegalArgumentException.class, () ->
                new Subcategory(
                        1,
                        "Name",
                        "code",
                        null,
                        null,
                        Status.ACTIVE,
                        0,
                        CategoryTest.validCategory()
                )
        );
    }

    @Test
    void nullStatus_defaultsToInactive() {
        Subcategory subcategory = new Subcategory(
                1,
                "Name",
                "code",
                null,
                null,
                null,      // pass null status
                1,
                CategoryTest.validCategory()
        );
        assertEquals(Status.INACTIVE, subcategory.getStatus());
    }

    @Test
    void categoryCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Subcategory(
                        1,
                        "Name",
                        "code",
                        null,
                        null,
                        Status.ACTIVE,
                        1,
                        null      // null category
                )
        );
    }

}