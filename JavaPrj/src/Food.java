import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Food {
	private String foodName;
	private int count;
	private String expDate;
	private String desc;
}
