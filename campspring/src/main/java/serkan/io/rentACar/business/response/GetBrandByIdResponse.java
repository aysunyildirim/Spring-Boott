package serkan.io.rentACar.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandByIdResponse {
	private int id;
	private String name;
}
