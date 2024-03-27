package com.example.Repository;

import com.example.Entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface WikimediaDataRespository extends JpaRepository<WikimediaData,Long> {
}
