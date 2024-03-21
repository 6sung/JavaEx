import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
	private String name;
	private String genre;
	private String manager;
	private String actor;
	private String startDate;
}