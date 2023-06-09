package com.example.favouriterecipe.service;

/**
 * Handles ID not found scenarios
 *
 * @author Prabu
 */
public class IdNotFoundException extends RuntimeException {
    private final Long id;

    /**
     * Constructor initialization
     *
     * @param id ID not found
     */
    public IdNotFoundException(Long id) {
        this.id = id;
    }

    /**
     * Get ID not found
     *
     * @return ID
     */
    public Long getId() {
        return id;
    }
}
