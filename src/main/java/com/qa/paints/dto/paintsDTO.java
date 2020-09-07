package com.qa.paints.dto;

public class paintsDTO {
        private Long id;
        private String name;
        private String colour;
        private int stock;

        public paintsDTO() {
        }

        public paintsDTO(String title, String description) {
            this.name = title;
            this.colour = description;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColour() {
            return colour;
        }

        public void setColour(String  colour) {
            this.colour = colour;
        }

        public int getStock(){return stock;}

        public void setStock(int stock){this.stock = stock;}

    }
