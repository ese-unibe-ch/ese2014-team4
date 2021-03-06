package ch.unibe.ese2014.team4.model.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ch.unibe.ese2014.team4.model.Visit;

public interface VisitDao extends CrudRepository<Visit,Long> {

	public Visit findById(Long id);

	public List<Visit> findAllByAdId(long adId);


}
