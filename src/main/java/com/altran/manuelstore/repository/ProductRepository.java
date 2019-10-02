package com.altran.manuelstore.repository;

import com.altran.manuelstore.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Produto, Integer>{

}
