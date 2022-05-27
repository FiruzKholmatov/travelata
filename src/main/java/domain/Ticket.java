package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode

public class Ticket implements Comparable<Ticket> {

    int id;
    int price;
    String departurePort;
    String arrivingPort;
    int timeInMinutes;

    @Override
    public int compareTo(Ticket t) {
        return this.price - t.price;
    }
}
