package kg.teksher.api.service;

import kg.teksher.api.dto.ScanRequest;
import kg.teksher.api.entity.Scan;
import kg.teksher.api.repository.ScanRepository;
import org.springframework.stereotype.Service;

@Service
public class ScanService {

    private final ScanRepository repository;

    public ScanService(ScanRepository repository) {
        this.repository = repository;
    }

    public Scan save(ScanRequest request) {
        return repository.save(new Scan(request.getCode()));
    }
}