package com.tiffinebooking.tiffinmodule.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiffinebooking.tiffinmodule.dto.NewTiffinDto;
import com.tiffinebooking.tiffinmodule.dto.UpdateTiffinDto;
import com.tiffinebooking.tiffinmodule.entity.Tiffins;
import com.tiffinebooking.tiffinmodule.repository.TiffinsRepository;
import com.tiffinebooking.tiffinmodule.service.TiffinService;

@Service
public class TiffinServiceimpl implements TiffinService {
	
	@Autowired
	private TiffinsRepository repository;

	@Override
	public String createNewTiffin(NewTiffinDto dto) {
		Tiffins tiffin  = new Tiffins();
		tiffin.setTiffinName(dto.getTiffinName());
		tiffin.setDescrption(dto.getDescrption());
		tiffin.setPrice(dto.getPrice());
		repository.save(tiffin);
		return "New "+dto.getTiffinName()+" tiffin Created";
	}

	@Override
	public Tiffins getTiffinById(long tId) {
		Tiffins tiffin = repository.findById(tId).get();
		return tiffin;
	}

	@Override
	public String updateTiffinInfo(UpdateTiffinDto dto) {
		Tiffins tiffin = repository.findById(dto.getTiffinId()).get();
		tiffin.setTiffinName(dto.getTiffinName());
		tiffin.setDescrption(dto.getDescrption());
		tiffin.setPrice(dto.getPrice());
		repository.save(tiffin);
		return "The "+dto.getTiffinName()+" data get Updated.";
	}

	@Override
	public String deleteTiffinById(long tId) {
		repository.deleteById(tId);
		return "The Tiffin With Id "+tId+" get Deleted.";
	}

	@Override
	public long getTiffinPriceById(long tId) {
		Tiffins tiffin =  repository.findById(tId).get();
		long price =  tiffin.getPrice();
		return price;
	}

	@Override
	public List<Tiffins> getAllTiffins() {
		List<Tiffins> allTiffins = repository.findAll();
		return allTiffins;
	}

}
