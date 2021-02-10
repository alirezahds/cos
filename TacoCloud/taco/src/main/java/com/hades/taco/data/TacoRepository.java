package com.hades.taco.data;

import com.hades.taco.Taco;

import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}
