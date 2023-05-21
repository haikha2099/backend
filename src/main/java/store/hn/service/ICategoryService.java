package store.hn.service;

import java.util.List;

import store.hn.dto.CategoryDTO;
import store.hn.entity.Category;

public interface ICategoryService {

	List<Category> getListCategories();
	
	public void creatCategory(CategoryDTO cgDTO);
	
	void updateCategory(int id, Category cg);
	
	void deleteCategory(int id);
	
}
