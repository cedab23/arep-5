package com.arep.majima.construction.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arep.majima.construction.app.model.Building;
import com.arep.majima.construction.app.model.dto.BuildingDto;
import com.arep.majima.construction.app.repository.BuildingRepository;
import com.arep.majima.construction.app.utils.Mapper;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepository repository;

    @Autowired
    private Mapper buildMapper;

    public BuildingDto createBuilding(BuildingDto dto) {

        Building newBuilding = buildMapper.toEntity(dto);

        return buildMapper.toDto(this.repository.save(newBuilding));
    }

    public BuildingDto findById(Long id) {
        return buildMapper.toDto(this.repository.findById(id).get());
    }

    public List<Building> getAllBuildings() {
        return this.repository.findAll();
    }

    public BuildingDto updateBuilding(Long id, BuildingDto dto) {
        Building changeBuilding = this.repository.findById(id).get();

        if (changeBuilding == null) {
            return null;
        }
        changeBuilding.setAddress(dto.getAddress());
        changeBuilding.setDescription(dto.getDescription());
        changeBuilding.setName(dto.getName());
        changeBuilding.setPrice(dto.getPrice());
        changeBuilding.setSize(dto.getSize());

        return buildMapper.toDto(this.repository.save(changeBuilding));

    }

    public boolean deleteBuilding(Long id) {
        if (!this.repository.existsById(id)) {
            return false;
        }
        this.repository.deleteById(id);
        return true;
    }

}
