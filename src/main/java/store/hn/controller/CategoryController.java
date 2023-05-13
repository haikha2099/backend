package store.hn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import store.hn.entity.Category;
import store.hn.service.CategoryService;

@RestController
@RequestMapping(value = "api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService  cgService;
	
	@GetMapping(value = "/list")
	private List<Category> getListCategories(){
		return cgService.getListCategories();
	}
	
	
}
