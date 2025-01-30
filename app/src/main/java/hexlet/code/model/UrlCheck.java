package hexlet.code.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UrlCheck {
    private long id;
    private int statusCode;
    private String title;
    private String h1;
    private String description;
    private LocalDateTime createdAt;
    private long urlId;

    public UrlCheck(int statusCode, long urlId) {
        this.statusCode = statusCode;
        this.urlId = urlId;
    }
}
