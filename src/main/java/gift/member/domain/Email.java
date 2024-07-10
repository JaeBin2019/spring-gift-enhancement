package gift.member.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import gift.product.domain.ProductPrice;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Email {
    @Column(name = "email")
    private String value;

    public Email() {}
    public Email(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    // JSON 직렬화를 위해 @JsonValue 사용
    @JsonValue
    public String toJson() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email that = (Email) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
