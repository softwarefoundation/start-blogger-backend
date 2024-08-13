package com.softwarefoundations.blogger.repository;

import com.softwarefoundations.blogger.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRespository extends JpaRepository<PostEntity, Long> {
}
