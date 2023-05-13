package store.hn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.hn.entity.Category;
import store.hn.repository.ICategoryRepository;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private ICategoryRepository cgRepository;
	
	@Override
	public List<Category> getListCategories() {
		// TODO Auto-generated method stub
		return cgRepository.findAll();
	}

	

	@Override
	public void updateCategory() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void creatCategory(Category cgs) {
		cgRepository.save(cgs);
	}



	@Override
	public void deleteCategory(int id) {
		cgRepository.deleteById(id);
	}

}
