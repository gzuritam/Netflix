package com.netflix.rest.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.netflix.rest.dto.CategoryDto;
import com.netflix.rest.model.Category;
import com.netflix.rest.repository.CategoryRepository;
import com.netflix.rest.service.CategoryServiceI;

@Service
@Qualifier("CategoryServiceImpl")
public class CategoryServiceImpl implements CategoryServiceI {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	@Qualifier("CategoryRepository")
	private CategoryRepository categoryRepository;
	
	@Override
	public CategoryDto findById(Long id) {
		return modelMapper.map(categoryRepository.findById(id).get(), CategoryDto.class);
	}
	
	@Override
	public List<CategoryDto> listAllCategories() {
		return this.categoryRepository.findAll()
				.stream()
				.map(category -> modelMapper.map(category, CategoryDto.class))
				.collect(Collectors.toList());
	}
	
}
