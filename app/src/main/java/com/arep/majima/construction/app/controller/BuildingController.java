package com.arep.majima.construction.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arep.majima.construction.app.model.Building;
import com.arep.majima.construction.app.model.dto.BaseApiResponse;
import com.arep.majima.construction.app.model.dto.BuildingDto;
import com.arep.majima.construction.app.service.BuildingService;
import com.arep.majima.construction.app.utils.ApiResponseBuilder;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService service;

    @Autowired
    private ApiResponseBuilder responseBuilder;

    // GET /building
    @GetMapping
    public ResponseEntity<BaseApiResponse<List<Building>>> getAll() {
        return responseBuilder.success(service.getAllBuildings(), "All buildings succesfully fetched");
    }

    // GET /building?id={id}
    @GetMapping(params = { "id" })
    public ResponseEntity<BaseApiResponse<BuildingDto>> byId(@RequestParam Long id) {
        try {
            return responseBuilder.success(service.findById(id), "Building was found by id: " + id);

        } catch (Exception e) {
            return responseBuilder.badRequest(null, "Could not find building by id: " + id);
        }

    }

    // POST /building
    @PostMapping
    public ResponseEntity<BaseApiResponse<BuildingDto>> add(@Valid @RequestBody BuildingDto newBuilding) {

        try {
            return responseBuilder.created(service.createBuilding(newBuilding), "Building was succesfully created");
        } catch (Exception e) {
            return responseBuilder.internalServerError(null, "Could not create building");
        }

    }

    // PUT /building?id={id}
    @PutMapping(params = { "id" })
    public ResponseEntity<BaseApiResponse<BuildingDto>> changeBuilding(@Valid @RequestBody BuildingDto changeDto,
            @RequestParam Long id) {
        try {
            return responseBuilder.success(service.updateBuilding(id, changeDto),
                    "Building information was succesfully modified");
        } catch (Exception e) {
            return responseBuilder.internalServerError(null, "Could not modify Building with id: " + id);
        }
    }

    // DELETE /building?id={id}
    @DeleteMapping(params = {"id"})
    public ResponseEntity<BaseApiResponse<Boolean>> delete(@RequestParam Long id) {
        try {
            return responseBuilder.success(service.deleteBuilding(id), "Building was successfully deleted");

        } catch (Exception e) {
            return responseBuilder.badRequest(null, "Could not delete building by id: " + id);
        }

    }    

}
