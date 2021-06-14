package com.netflix.rest.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.netflix.rest.model.TvShow;
import com.netflix.rest.repository.CategoryRepository;
import com.netflix.rest.repository.TvShowRepository;
import com.netflix.rest.service.TvShowServiceI;

@Service
@Qualifier("TvShowServiceImpl")
public class TvShowServiceImpl implements TvShowServiceI {

	 @Autowired
	 @Qualifier("TvShowRepository")
	 public TvShowRepository tvShowRepository;
	 
	 @Autowired
	 @Qualifier("CategoryRepository")
	 public CategoryRepository categoryRepository;

	@Override
	public List<TvShow> listTvShowByCategory(Long categoryId) {
		return tvShowRepository.findByCategory(categoryRepository.findById(categoryId).get());
	}
	
	 
	 
	
}
