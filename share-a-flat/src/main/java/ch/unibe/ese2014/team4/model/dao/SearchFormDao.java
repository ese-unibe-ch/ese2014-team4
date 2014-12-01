package ch.unibe.ese2014.team4.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.unibe.ese2014.team4.model.SearchForm;
import ch.unibe.ese2014.team4.model.User;

public interface SearchFormDao extends CrudRepository<SearchForm,Long> {

	public List<SearchForm> findAllByOwner(User owner);
}
