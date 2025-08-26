package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bean.ATMCard;

public interface ATMCardRepository extends JpaRepository<ATMCard,String>{

}