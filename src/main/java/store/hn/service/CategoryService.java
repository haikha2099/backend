package store.hn.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.hn.dto.CategoryDTO;
import store.hn.entity.Category;
import store.hn.repository.ICategoryRepository;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private ICategoryRepository cgRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Category> getListCategories() {
		
		return cgRepository.findAll();
	}

	

	@Override
	public void updateCategory(int id, Category cg) {
		Category cgInfor = cgRepository.getById(id);
		
		cgInfor.setCg_name(cg.getCg_name());
		
		cgRepository.save(cgInfor);
	}

	@Override
	public void deleteCategory(int id) {
		cgRepository.deleteById(id);
		
	}



	@Override
	public void creatCategory(CategoryDTO cgDTO) {
		Category cgnew = modelMapper.map(cgDTO, Category.class);
		
		cgRepository.save(cgnew);
		
	}
	
	

}
