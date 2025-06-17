package com.techforge.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    public static Category validCategory() {
        return new Category(
                1,
                "Programming",
                "programming",
                null,
                null,
                Status.ACTIVE,
                1,
                null,
                null
        );
    }

    @Test
    void createCategoryShouldPass() {
        assertDoesNotThrow(() -> {
            validCategory();
        });
    }

    @Test
    void nameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Category(
                        1,
                        null,
                        "code",
                        null,
                        null,
                        Status.ACTIVE,
                        1,
                        null,
                        null
                )
        );
    }

    @Test
    void nameCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new Category(
                        1,
                        "",
                        "code",
                        null,
                        null,
                        Status.ACTIVE,
                        1,
                        null,
                        null
                )
        );
    }

    @Test
    void nameCannotBeBlank() {
        assertThrows(IllegalArgumentException.class, () ->
                new Category(
                        1,
                        " ",
                        "code",
                        null,
                        null,
                        Status.ACTIVE,
                        1,
                        null,
                        null
                )
        );
    }

    @Test
    void codeCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Category(
                        1,
                        "Name",
                        null,
                        null,
                        null,
                        Status.ACTIVE,
                        1,
                        null,
                        null
                )
        );
    }

    @Test
    void codeCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new Category(
                        1,
                        "Name",
                        "",
                        null,
                        null,
                        Status.ACTIVE,
                        1,
                        null,
                        null
                )
        );
    }

    @Test
    void codeMustMatchPattern() {
        assertThrows(IllegalArgumentException.class, () ->
                new Category(
                        1,
                        "Name",
                        "Bad Code!",
                        null,
                        null,
                        Status.ACTIVE,
                        1,
                        null,
                        null
                )
        );
    }

    @Test
    void orderMustBeAtLeastOne() {
        assertThrows(IllegalArgumentException.class, () ->
                new Category(
                        1,
                        "Name",
                        "code",
                        null,
                        null,
                        Status.ACTIVE,
                        0,
                        null,
                        null
                )
        );
    }

    @Test
    void nullStatusDefaultsToInactive() {
        Category category = new Category(
                1,
                "Name",
                "code",
                null,
                null,
                null,       // pass null status
                1,
                null,
                null
        );
        assertEquals(Status.INACTIVE, category.getStatus());
    }
}