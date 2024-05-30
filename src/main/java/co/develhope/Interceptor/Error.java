package co.develhope.Interceptor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
public class Error {
    @Id
    @GeneratedValue
    private long id;

    private int statusCode;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Error(long id, int statusCode, String description) {
        this.id = id;
        this.statusCode = statusCode;
        this.description = description;
    }

    public Error (){}
}
