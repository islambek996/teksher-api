package kg.teksher.api.controller;
import kg.teksher.api.entity.Scan;
import kg.teksher.api.repository.ScanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/scans")
@RequiredArgsConstructor
public class ScanController {

    private final ScanRepository repository;

    @GetMapping
    public List<Scan> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Scan save(@RequestBody Scan scan) {
        return repository.save(scan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        repository.deleteAll();
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportCsv() {

        StringBuilder csv = new StringBuilder();

        csv.append("Код маркировки\r\n");

        repository.findAll().forEach(scan ->
                csv.append(scan.getCode()).append("\r\n")
        );

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=scans.csv")
                .contentType(new MediaType("text", "csv", StandardCharsets.UTF_8))
                .body(csv.toString().getBytes(StandardCharsets.UTF_8));
    }

}