package serkan.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serkan.io.rentACar.business.abstracts.BrandService;
import serkan.io.rentACar.business.requests.CreateBrandRequest;
import serkan.io.rentACar.business.requests.DeleteBrandRequest;
import serkan.io.rentACar.business.requests.UpdateBrandRequest;
import serkan.io.rentACar.business.response.GetAllBrandsResponse;
import serkan.io.rentACar.business.response.GetBrandByIdResponse;
import serkan.io.rentACar.dataAccess.abstracts.BrandRepository;
import serkan.io.rentACar.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService {

	private BrandRepository brandReposity;
	
	
	@Autowired
	public BrandManager(BrandRepository brandReposity) {
		this.brandReposity = brandReposity;
	}
	


	@Override
	public List<GetAllBrandsResponse> getAll() {
		//iş kuralları  
		
		List<Brand> resultBrands = brandReposity.findAll();//databseden gelen result burası 
		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
		
		
		for (Brand brand : resultBrands) {//databaseden ne kadar veri geliyorsa hepsinin diğer tipe dönüşmesi gerekli
			
			GetAllBrandsResponse responsItem = new GetAllBrandsResponse();
			responsItem.setId(brand.getId());
			responsItem.setName(brand.getName());
			
			brandsResponse.add(responsItem);
		}
		
		return brandsResponse;
	}


	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		Brand serkan = new Brand();
		serkan.setName(createBrandRequest.getName());
		//database tablosu olan Brand'ı tanır biz öncesinde başka bir tip ile bu brandi saklıyoruz 
		this.brandReposity.save(serkan);
		
	}



	@Override
	public void delete(DeleteBrandRequest deleteBrandRequest) {
		
		Brand brand = new Brand();
		
		brand.setId(deleteBrandRequest.getId());
		
		Brand deletedBrand = this.brandReposity.findById(brand.getId()).get();
		
		this.brandReposity.delete(deletedBrand);
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		
		Brand brand = new Brand();
		brand.setId(updateBrandRequest.getId());
		brand.setName(updateBrandRequest.getName());
		
		this.brandReposity.save(brand);
	}



	@Override
	public GetBrandByIdResponse getBrandById(int id) {
		
		Brand brand = this.brandReposity.findById(id).get();
		
		GetBrandByIdResponse brandResponse = new GetBrandByIdResponse();
		brandResponse.setId(brand.getId());
		brandResponse.setName(brand.getName());
		
		return brandResponse;
	}

	
	
	
}
