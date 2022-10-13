package houses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HighRiseHouse extends House {
    private int countOfFloors;
    private int countOfRoomsAtFloor;
    private int outbuildings;
}
