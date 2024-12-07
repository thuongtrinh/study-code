package com.txt.eshopperboot.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.txt.eshopperboot.dto.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByUsername(String username);

    @Modifying
    @Query(value = "update User u set u.firstName = :firstName, u.middleName = :middleName, u.lastName = :lastName, u.phone = :phone, "
            + "u.mobilePhone = :mobilePhone, u.fax = :fax where u.username = :username")
    int updateJPQL(@Param("username") String username, @Param("firstName") String firstname,
                   @Param("lastName") String lastName, @Param("phone") String phone, @Param("middleName") String middleName,
                   @Param("mobilePhone") String mobilePhone, @Param("fax") String fax);

//	@Modifying
//	@Query(value = "update user_detail set first_name = ?, middle_name = ?, last_name = ?, phone =  ?, "
//			+ "mobile_phone = ?, fax = ? where username = ?", nativeQuery = true)
//	int updateNative(String username, String firstname, String lastName, String phone, String middleName, String mobilePhone, String fax);
}


