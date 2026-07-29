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
import kg.teksher.api.dto.ParsedScan;
import kg.teksher.api.util.Gs1Parser;

@RestController
@RequestMapping("/api/scans")
@RequiredArgsConstructor
public class ScanController {

    private final ScanRepository repository;

    @GetMapping
    public List<ParsedScan> getAll() {

        return repository.findAll()
                .stream()
                .map(Gs1Parser::parse)
                .toList();

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

        csv.append("\r\n");

        repository.findAll().forEach(scan -> {
            String code = scan.getCode();

            if (code != null && !code.isEmpty() && code.charAt(0) == 29) {
                code = code.substring(1);
            }

            csv.append(code).append("\r\n");
        });

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=scans.csv")
                .contentType(new MediaType("text", "csv", StandardCharsets.UTF_8))
                .body(csv.toString().getBytes(StandardCharsets.UTF_8));
    }

}