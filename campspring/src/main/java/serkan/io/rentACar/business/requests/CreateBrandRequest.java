package serkan.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {

	//buraya data alıyorum request 
	private String name;
	
}

