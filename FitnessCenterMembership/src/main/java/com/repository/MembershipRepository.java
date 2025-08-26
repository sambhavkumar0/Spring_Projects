package com.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.model.Membership;
//Provide necessary annotation
@Repository
public interface MembershipRepository extends JpaRepository<Membership, String> {
   
	 // Provide necessary methods to view memberships by benefit, view memberships by membership type and monthly access hours and get membership count for each type
	 // Custom method to find memberships where the benefits string contains the given benefit
    List<Membership> findByBenefitsContaining(String benefit);
    
    // Custom method to find memberships by type and where access hours are greater than the given value
    List<Membership> findByMembershipTypeAndMonthlyAccessHoursGreaterThan(String membershipType, int monthlyAccessHours);

    // Custom query to get the count of memberships grouped by type
    @Query("SELECT m.membershipType, COUNT(m.membershipType) FROM Membership m GROUP BY m.membershipType")
    List<Object[]> getMembershipCountTypeWise();
}