package com.arep.majima.construction.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arep.majima.construction.app.model.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

}
