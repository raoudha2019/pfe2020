package com.telnet.qcm.dao;

import com.telnet.qcm.entities.User;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userrepository")

public interface UserRepository extends JpaRepository<User, Long>{

    @Query("SELECT u FROM User u where u.firstname =:firstname and u.password =:password")
    User findUserBynamepass(@Param("firstname") String firstname, @Param("password") String password );

    @Query("SELECT u FROM User u where u.firstname =:firstname")
    User findUserByfirstname(@Param("firstname") String firstname);

   /* @Query("SELECT u FROM User u where u.email =:email")
    User findUserByEmail(@Param("email") String email);*/

    @Query("SELECT u FROM User u where u.email =:email")
    List<User> findUserByEmail(@Param("email") String email);

    @Query ("SELECT u FROM User u WHERE u.role.id =: RoleId")
    List<User> findUserByRole(@Param("RoleId")  Long RoleId);

}