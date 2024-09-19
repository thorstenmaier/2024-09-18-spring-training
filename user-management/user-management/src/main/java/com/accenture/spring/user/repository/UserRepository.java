package com.accenture.spring.user.repository;

import com.accenture.spring.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    Set<User> findByLastname(String lastname);
    User findByFirstnameAndLastname(String firstname, String lastname);
    List<User> findByLastnameLikeOrderByLastnameDesc(String lastnameLike);

    @Query("from User WHERE firstname like :firstname")
    Set<User> holMirUser(@Param("firstname") String firstname);


}
