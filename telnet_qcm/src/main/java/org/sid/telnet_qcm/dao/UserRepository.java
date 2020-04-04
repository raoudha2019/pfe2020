package org.sid.telnet_qcm.dao;

import org.sid.telnet_qcm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("userrepository")

public interface UserRepository extends JpaRepository<User, Long>{


    @Query("SELECT u FROM User u where u.firstname =:firstname and u.password =:password")
    User findUserBynamepass(@Param("firstname") String firstname, @Param("password") String password );


    @Query("SELECT u FROM User u where u.firstname =:firstname")
    User findUserByfirstname(@Param("firstname") String firstname);


}