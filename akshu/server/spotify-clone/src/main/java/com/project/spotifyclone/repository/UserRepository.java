package com.project.spotifyclone.repository;

import com.project.spotifyclone.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}