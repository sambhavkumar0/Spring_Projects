package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Add this import for the @Transactional annotation
import jakarta.transaction.Transactional; 

import com.entity.Module;
import com.exception.InvalidModuleException;
import com.repository.ModuleRepository;

@Service
public class ModuleServiceImpl implements IModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public Module addModule(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    @Transactional // This annotation ensures the database update is committed.
    public Module updateModuleFee(String moduleId, double moduleFee) throws InvalidModuleException {
        Optional<Module> optionalModule = moduleRepository.findById(moduleId);

        if (optionalModule.isPresent()) {
            Module module = optionalModule.get();
            module.setModuleFee(moduleFee);
            // The save call within a @Transactional method ensures the update is persisted
            return moduleRepository.save(module);
        } else {
            throw new InvalidModuleException("Module with ID " + moduleId + " not found.");
        }
    }

    @Override
    public Module viewModuleById(String moduleId) throws InvalidModuleException {
        return moduleRepository.findById(moduleId)
            .orElseThrow(() -> new InvalidModuleException("Module with ID " + moduleId + " not found."));
    }
 
    @Override
    public List<Module> viewAllModules() {
	    return moduleRepository.findAll();
    }

    @Override
    public Module deleteModule(String moduleId) throws InvalidModuleException {
        Module moduleToDelete = moduleRepository.findById(moduleId)
            .orElseThrow(() -> new InvalidModuleException("Module with ID " + moduleId + " not found."));
        
        moduleRepository.delete(moduleToDelete);
        
	    return moduleToDelete;
}
}