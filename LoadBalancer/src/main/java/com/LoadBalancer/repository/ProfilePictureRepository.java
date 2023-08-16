package com.LoadBalancer.repository;

import com.LoadBalancer.model.ProfilePicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilePictureRepository extends JpaRepository<ProfilePicture, Long> {
}

