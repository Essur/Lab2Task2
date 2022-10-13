package houses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class House {
    private String location;

    public House(String location) {
        this.location = location;
    }
}
