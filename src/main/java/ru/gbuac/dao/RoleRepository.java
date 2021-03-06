package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.Role;

import java.util.List;

@Transactional(readOnly = true)
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Role r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT r FROM Role r JOIN r.users u WHERE lower(u.name)=lower(:userName)")
    List<Role> getRolesByUsername(@Param("userName") String userName);
}


