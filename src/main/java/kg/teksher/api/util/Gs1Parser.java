package kg.teksher.api.util;

import kg.teksher.api.dto.ParsedScan;
import kg.teksher.api.entity.Scan;

public class Gs1Parser {

    private static final char GS = 29;

    public static ParsedScan parse(Scan scan) {

        String code = scan.getCode();

        if (code.startsWith(String.valueOf(GS))) {
            code = code.substring(1);
        }

        String gtin = "";
        String serial = "";
        String crypto = "";

        int gtinIndex = code.indexOf("01");

        if (gtinIndex != -1 && code.length() >= gtinIndex + 16) {
            gtin = code.substring(gtinIndex + 2, gtinIndex + 16);
        }

        int serialIndex = code.indexOf("21");

        if (serialIndex != -1) {

            int start = serialIndex + 2;
            int end = code.indexOf(GS, start);

            if (end != -1) {
                serial = code.substring(start, end);
            }

        }

        int cryptoIndex = code.indexOf("92");

        if (cryptoIndex != -1) {
            crypto = code.substring(cryptoIndex + 2);
        }

        return new ParsedScan(
                scan.getId(),
                gtin,
                serial,
                crypto,
                scan.getCode()
        );
    }

}