package kg.teksher.api.repository;

import kg.teksher.api.entity.Scan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScanRepository extends JpaRepository<Scan, Long> {
    List<Scan> findByUserId(String userId);
}

