package main.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.models.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
	
	
	@Query("from Tour t left join fetch t.comments where t.id = :id")
	public Tour tourByIdWithComments(@Param("id") Long id);
	
	public List<Tour> findByDateBetween(Date startDate, Date endDate);
}
