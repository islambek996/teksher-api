package kg.teksher.api.controller;

import kg.teksher.api.dto.ScanRequest;
import kg.teksher.api.entity.Scan;
import kg.teksher.api.service.ScanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scans")
public class ScanController {

    private final ScanService service;

    public ScanController(ScanService service) {
        this.service = service;
    }

    @PostMapping
    public Scan save(@RequestBody ScanRequest request) {
        return service.save(request);
    }
}