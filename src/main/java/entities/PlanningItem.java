package entities;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class PlanningItem {

    private String dayOfWeek;
    private String date;
    private String shift;
    private String UurRegeling;
    private String opvoeder;
    private String amountOfHours;

}

