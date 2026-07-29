package kg.teksher.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParsedScan {

    private Long id;

    private String gtin;

    private String serial;

    private String crypto;

    private String code;

}