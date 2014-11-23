package ch.unibe.ese2014.team4.model.dao;

import org.springframework.data.repository.CrudRepository;

import ch.unibe.ese2014.team4.model.User;
import ch.unibe.ese2014.team4.model.Visit;

public interface VisitDao extends CrudRepository<Visit,Long> {


}
