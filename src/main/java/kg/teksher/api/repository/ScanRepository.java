package kg.teksher.api.repository;

import kg.teksher.api.entity.Scan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScanRepository extends JpaRepository<Scan, Long> {
}