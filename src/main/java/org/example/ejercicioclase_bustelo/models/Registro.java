package org.example.ejercicioclase_bustelo.models;


import lombok.Data;

    @Data
    public class Registro {
        private Long id;
        private String nombre;
        private String categoria;
        private Boolean disponible;
    }

