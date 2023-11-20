package com.example.Proj1_2019202005.repository;

import com.example.Proj1_2019202005.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long>{ // 생성된 DB에 접근하는 인터페이스
}