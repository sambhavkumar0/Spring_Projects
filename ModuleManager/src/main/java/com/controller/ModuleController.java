package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Module;
import com.exception.InvalidModuleException;
import com.service.IModuleService;

@RestController
// The @RequestMapping("/api/modules") has been removed to match the required endpoints.
public class ModuleController {

    @Autowired
    private IModuleService moduleService;

    // This now correctly maps to POST /addModule
    @PostMapping("/addModule")
    public ResponseEntity<Module> addModule(@RequestBody Module module) {
        Module addedModule = moduleService.addModule(module);
        return new ResponseEntity<>(addedModule, HttpStatus.OK);
    }
    
    // This now correctly maps to PUT /updateModuleFee/{moduleId}/{moduleFee}
    @PutMapping("/updateModuleFee/{moduleId}/{moduleFee}")
    public ResponseEntity<Module> updateModuleFee(@PathVariable String moduleId, @PathVariable double moduleFee) throws InvalidModuleException {
        Module updatedModule = moduleService.updateModuleFee(moduleId, moduleFee);
        return new ResponseEntity<>(updatedModule, HttpStatus.OK);
    }
    
    // This now correctly maps to GET /viewModuleById/{moduleId}
    @GetMapping("/viewModuleById/{moduleId}")
    public ResponseEntity<Module> viewModuleById(@PathVariable String moduleId) throws InvalidModuleException {
        Module module = moduleService.viewModuleById(moduleId);
        return new ResponseEntity<>(module, HttpStatus.OK);
    }
    
    // This now correctly maps to GET /viewAllModules
    @GetMapping("/viewAllModules")
    public ResponseEntity<List<Module>> viewAllModules () {
        List<Module> modules = moduleService.viewAllModules();
        return new ResponseEntity<>(modules, HttpStatus.OK);
    }
    
    // This now correctly maps to DELETE /deleteModule/{moduleId}
    @DeleteMapping("/deleteModule/{moduleId}")
    public ResponseEntity<Module> deleteModule(@PathVariable String moduleId) throws InvalidModuleException {
        Module deletedModule = moduleService.deleteModule(moduleId);
        return new ResponseEntity<>(deletedModule, HttpStatus.OK);
}
}