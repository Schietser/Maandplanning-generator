package entities;

import java.util.List;

public record Opvoeder(String name, List<Shift> shifts) {
}
