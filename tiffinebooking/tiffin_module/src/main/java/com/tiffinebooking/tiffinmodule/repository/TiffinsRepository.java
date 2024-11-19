package com.tiffinebooking.tiffinmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiffinebooking.tiffinmodule.entity.Tiffins;
@Repository
public interface TiffinsRepository extends JpaRepository<Tiffins, Long> {

}
