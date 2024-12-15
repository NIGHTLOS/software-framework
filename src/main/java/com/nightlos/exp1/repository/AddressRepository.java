package com.nightlos.exp1.repository;

import com.nightlos.exp1.dto.Address;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
    @Query("select * from address a where a.user_id=:uid")
    List<Address> findAddresses(int uid);
}
