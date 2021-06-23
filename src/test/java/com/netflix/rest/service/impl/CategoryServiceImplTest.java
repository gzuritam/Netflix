package com.netflix.rest.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.netflix.rest.exception.NetflixException;
import com.netflix.rest.repository.CategoryRepository;

@EnableJpaRepositories(basePackageClasses = CategoryRepository.class)
@DataJpaTest
@RunWith(MockitoJUnitRunner.class)
class CategoryServiceImplTest {
	
	@InjectMocks
	CategoryServiceImpl categoryServiceImpl;
	
	@Mock
	ModelMapper modelMapper;
	
	@Mock
	CategoryRepository categoryRepository;

	@Test
	void findById() throws NetflixException {
		categoryServiceImpl.findById(2L);
	}

}
