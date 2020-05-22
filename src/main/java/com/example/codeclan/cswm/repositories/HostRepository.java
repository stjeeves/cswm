package com.example.codeclan.cswm.repositories;

import com.example.codeclan.cswm.models.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
}
