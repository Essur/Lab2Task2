package houses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrivateHouse extends House {
    private int countOfRooms;
    private int countOfResidents;
    private double sizeOfTerrain;

}
