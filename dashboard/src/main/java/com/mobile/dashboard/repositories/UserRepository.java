package com.mobile.dashboard.repositories;

import com.mobile.dashboard.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
