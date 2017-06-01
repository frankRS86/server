package main.java.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public interface IUserPersistence extends CrudRepository<User, String>
{
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	Iterable<User> findAll();
}
