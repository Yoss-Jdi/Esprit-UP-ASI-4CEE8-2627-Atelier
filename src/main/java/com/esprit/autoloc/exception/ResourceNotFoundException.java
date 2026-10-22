package com.esprit.autoloc.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String ressource, Long id) {
        super(ressource + " introuvable, id: " + id);
    }
}
