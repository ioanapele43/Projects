package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

   // User findByEmail(String username);
    @Query("SELECT u FROM User u WHERE u.email = ?1 ")
    public User findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.id = ?1 ")
    public User findByID(Long id);
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.lastName =:name, u.firstName=:fname ,u.role=:rol WHERE (u.email = :e) ")
    public void updateUser(@Param("name")String ln,@Param("fname")String fn,@Param("rol")String r, @Param("e")String email);
   @Modifying(clearAutomatically = true)
   @Query("Delete User u  WHERE (u.email = :e) ")
   public void deleteUser( @Param("e")String email);
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.lastName =:name, u.firstName=:fname ,u.role=:rol, u.password=:pass,u.address=:adr WHERE (u.email = :e) ")
    public void updateUserPass(@Param("name")String ln,@Param("fname")String fn,@Param("rol")String r,@Param("pass")String p,@Param("adr")String adr, @Param("e")String email);


}
