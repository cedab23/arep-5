package com.arep.majima.construction.app.utils;

import org.springframework.stereotype.Component;

import com.arep.majima.construction.app.model.Building;
import com.arep.majima.construction.app.model.dto.BuildingDto;

@Component
public class Mapper {

    public BuildingDto toDto(Building building) {
        if (building == null) {
            return null;
        }
        BuildingDto dto = new BuildingDto();
        dto.setAddress(building.getAddress());
        dto.setDescription(building.getDescription());
        dto.setName(building.getName());
        dto.setPrice(building.getPrice());
        dto.setSize(building.getSize());

        return dto;
    }

    public Building toEntity(BuildingDto dto) {
        if (dto == null) {
            return null;
        }
        Building building = new Building();
        building.setAddress(dto.getAddress());
        building.setDescription(dto.getDescription());
        building.setName(dto.getName());
        building.setPrice(dto.getPrice());
        building.setSize(dto.getSize());

        return building;
    }

}
