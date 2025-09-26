package com.arep.majima.construction.app.model.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BuildingDto {
    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Double size;

    private String description;

    public BuildingDto(String name, String address, BigDecimal price, Double size, String description) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.size = size;
        this.description = description;
    }

    

    public BuildingDto() {
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
