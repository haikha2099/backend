package store.hn.controller;

import java.util.List;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import store.hn.dto.CategoryDTO;
import store.hn.dto.ProductDTO;
import store.hn.entity.Category;
import store.hn.service.CategoryService;

@RestController
@RequestMapping(value = "api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService  cgService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(value = "/list")
	private List<CategoryDTO> getListCategories(){
		List<Category> listCategory =  cgService.getListCategories();
		
		List<CategoryDTO> listCategoryDTO = modelMapper.map(listCategory,new TypeToken< List<CategoryDTO> >(){}.getType());
		
		return listCategoryDTO;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> creatCategory(@RequestBody CategoryDTO cgDTO){
		System.out.println(cgDTO);
		cgService.creatCategory(cgDTO);
		
		JSONObject message = new JSONObject();
		message.put("rusultText", "creat category success");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCategory(@PathVariable(name = "id")int id,@RequestBody Category cg){
		System.out.println(id);
		cgService.updateCategory(id, cg);
		
		JSONObject message = new JSONObject();
		message.put("rusultText", "update category success");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") int id) {
		cgService.deleteCategory(id);
		JSONObject message = new JSONObject();
		message.put("rusultText", "category deleted");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
}
