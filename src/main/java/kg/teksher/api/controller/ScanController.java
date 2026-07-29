package kg.teksher.api.controller;

import kg.teksher.api.dto.ScanRequest;
import kg.teksher.api.entity.Scan;
import kg.teksher.api.service.ScanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scans")
public class ScanController {

    private final ScanService service;

    public ScanController(ScanService service) {
        this.service = service;
    }

    /**
     * Сохранить новый скан
     */
    @PostMapping
    public Scan save(@RequestBody ScanRequest request) {
        return service.save(request);
    }

    /**
     * Получить все сканы
     */
    @GetMapping
    public List<Scan> getAll() {
        return service.getAll();
    }

    /**
     * Получить скан по ID
     */
    @GetMapping("/{id}")
    public Scan getById(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Удалить один скан
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    /**
     * Очистить все сканы
     */
    @DeleteMapping
    public void deleteAll() {
        service.deleteAll();
    }
}