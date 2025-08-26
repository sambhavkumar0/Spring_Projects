package com.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Module {
	
   // Provide necessary Annotation
   @Id
   private String moduleId;
   private String moduleName;
   private double moduleFee;
   private int duration;
   private String difficultyLevel;
   public double getModuleFee() {
	   return moduleFee;
   }
   public void setModuleFee(double moduleFee) {
	// TODO Auto-generated method stub
	    this.moduleFee = moduleFee;
}


}