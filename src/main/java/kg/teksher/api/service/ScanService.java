package kg.teksher.api.service;

import kg.teksher.api.dto.ScanRequest;
import kg.teksher.api.entity.Scan;
import kg.teksher.api.repository.ScanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScanService {

    private final ScanRepository repository;

    public ScanService(ScanRepository repository) {
        this.repository = repository;
    }

    /**
     * Сохранить скан
     */
    public Scan save(ScanRequest request) {
        return repository.save(new Scan(request.getCode()));
    }

    /**
     * Получить все сканы
     */
    public List<Scan> getAll() {
        return repository.findAll();
    }

    /**
     * Получить скан по ID
     */
    public Scan getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Скан не найден"));
    }

    /**
     * Удалить скан
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Удалить все сканы
     */
    public void deleteAll() {
        repository.deleteAll();
    }
}