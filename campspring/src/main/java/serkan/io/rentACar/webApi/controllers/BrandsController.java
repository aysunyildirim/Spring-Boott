package serkan.io.rentACar.webApi.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import serkan.io.rentACar.business.abstracts.BrandService;
import serkan.io.rentACar.business.requests.CreateBrandRequest;
import serkan.io.rentACar.business.requests.DeleteBrandRequest;
import serkan.io.rentACar.business.requests.UpdateBrandRequest;
import serkan.io.rentACar.business.response.GetAllBrandsResponse;
import serkan.io.rentACar.business.response.GetBrandByIdResponse;
import serkan.io.rentACar.entities.concretes.Brand;

@RestController
@RequestMapping("/api/brands")//controller name
@CrossOrigin
public class BrandsController {

	private BrandService brandService;

	@Autowired //git paramaetrelerine bak Service için kim bunu implements etmiş bunun newlisini bul gel 
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	
	
	@GetMapping("/getall")
	public List<GetAllBrandsResponse> getAll(){
		
		return brandService.getAll();
				
	}
	
	
	@PostMapping("/add")
	public void add(@RequestBody CreateBrandRequest createBrandRequest) {
		
		this.brandService.add(createBrandRequest);
		
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		
		this.brandService.update(updateBrandRequest);
		
	}
	
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteBrandRequest deleteBrandRequest) {
		
		this.brandService.delete(deleteBrandRequest);

	}
	
	@GetMapping("/getbrandById/{id}")
	public GetBrandByIdResponse getBrandById(@RequestParam int id){
		return brandService.getBrandById(id);
				
	}
	
	
	
	
}
