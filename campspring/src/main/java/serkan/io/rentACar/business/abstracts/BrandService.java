package serkan.io.rentACar.business.abstracts;
import java.util.List;

import serkan.io.rentACar.business.requests.CreateBrandRequest;
import serkan.io.rentACar.business.requests.DeleteBrandRequest;
import serkan.io.rentACar.business.requests.UpdateBrandRequest;
import serkan.io.rentACar.business.response.GetAllBrandsResponse;
import serkan.io.rentACar.business.response.GetBrandByIdResponse;
import serkan.io.rentACar.entities.concretes.Brand;

public interface BrandService {
	//Response-Request Pattern 
	//List<Brand> getAll();//<Brand> database deki ham nesnedir..bu kullanıcıya açılmaz
	
	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
	void delete(DeleteBrandRequest deleteBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	GetBrandByIdResponse getBrandById(int id);
	
}
