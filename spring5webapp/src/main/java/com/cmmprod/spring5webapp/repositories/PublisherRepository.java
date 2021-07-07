package com.cmmprod.spring5webapp.repositories;
import com.cmmprod.spring5webapp.domain.Publisher;

import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    
}
