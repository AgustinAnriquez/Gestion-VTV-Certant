package com.agustin.vtv.dao;

import org.springframework.data.repository.CrudRepository;

import com.agustin.vtv.domain.Version;

public interface VersionAutomovilDao extends CrudRepository<Version, Integer> {

}
