package com.service;

import org.springframework.stereotype.Service;
import com.model.Admission;

@Service
public class AdmissionService {

    public double calculateProgramFee(Admission admission) {
        String programName = admission.getProgramName();
        double fee = 0.0;
        
        switch (programName) {
            case "Play Group":
                fee = 600.0;
                break;
            case "Nursery":
                fee = 800.0;
                break;
            case "Euro Junior":
                fee = 1000.0;
                break;
            case "Euro Senior":
                fee = 1200.0;
                break;
        }
        
        return fee;
        
}
}