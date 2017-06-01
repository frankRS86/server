package main.java.persistence;

import org.springframework.data.repository.CrudRepository;

public interface IUserPersistence extends CrudRepository<User, Long>{

}
