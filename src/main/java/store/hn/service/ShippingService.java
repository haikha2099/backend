package store.hn.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.hn.dto.ShippingDTO;
import store.hn.entity.Shipping;
import store.hn.repository.IShippingRepository;

@Service
public class ShippingService implements IShippingService{
	
	@Autowired
	private IShippingRepository spRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public List<Shipping> getListShipping() {
		return spRepository.findAll();
	}

	@Override
	public void updateShipping(int id, Shipping sp) {
		Shipping spInfor = spRepository.getById(id);
		
		spInfor.setPhone(sp.getPhone());
		spInfor.setAddress(sp.getAddress());
		
		spRepository.save(spInfor);
		
	}

	@Override
	public void deleteShipping(int id) {
		spRepository.deleteById(id);
		
	}

	@Override
	public void creatShipping(ShippingDTO spDTO) {
		
		Shipping spnew = modelMapper.map(spDTO, Shipping.class);
		
		spRepository.save(spnew);
	}

}
