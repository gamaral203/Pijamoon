package com.Pijamoon.pijamoon_backend.repository;

import com.Pijamoon.pijamoon_backend.model.UserModel;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
