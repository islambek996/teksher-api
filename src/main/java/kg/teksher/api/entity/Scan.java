package kg.teksher.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "scans")
public class Scan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 500)
    private String code;
    @Column(nullable = false)
    private String userId;


    public Scan() {
    }

    public Scan(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
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