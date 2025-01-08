package entities;

import java.util.Date;

public record PlanningItem(java.time.DayOfWeek DayOfWeek, Date date, Shift shift, Opvoeder opvoeder, int amountOfHours) {}
