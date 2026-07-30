package kg.teksher.api.dto;

public class ScanRequest {

    private String code;
    private String userId;

    public ScanRequest() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}