package com.tsourdos.javaee7restfulapi.repo;

import com.tsourdos.javaee7restfulapi.model.SuperUser;
import java.util.List;

/**
 *
 * @author s.tsourdos
 */
public interface UserRepository {

    public void delete(SuperUser user);

    public SuperUser find(int id);

    public List<SuperUser> findAll();

    public void save(SuperUser user);

}
