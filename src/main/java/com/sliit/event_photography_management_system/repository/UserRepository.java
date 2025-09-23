package com.sliit.event_photography_management_system.repository;
import com.sliit.event_photography_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUemailAndUpassword(String email, String password);
}
