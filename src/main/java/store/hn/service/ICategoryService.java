package store.hn.service;

import java.util.List;


import store.hn.entity.Category;

public interface ICategoryService {

	List<Category> getListCategories();
	
	public void creatCategory(Category cgs);
	
	void updateCategory();
	
	void deleteCategory(int id);
	
}
