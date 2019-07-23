package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.domain.Dolist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DolistRepository extends JpaRepository<Dolist,Long> {
}
