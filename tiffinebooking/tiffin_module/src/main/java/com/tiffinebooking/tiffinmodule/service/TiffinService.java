package com.tiffinebooking.tiffinmodule.service;

import java.util.List;

import com.tiffinebooking.tiffinmodule.dto.NewTiffinDto;
import com.tiffinebooking.tiffinmodule.dto.UpdateTiffinDto;
import com.tiffinebooking.tiffinmodule.entity.Tiffins;

public interface TiffinService {

	String createNewTiffin(NewTiffinDto dto);

	Tiffins getTiffinById(long tId);

	String updateTiffinInfo(UpdateTiffinDto dto);

	String deleteTiffinById(long tId);

	long getTiffinPriceById(long tId);

	List<Tiffins> getAllTiffins();

}
