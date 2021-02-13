package com.example.projekt.repository;

import com.example.projekt.model.UsedMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "materialUsed", collectionResourceRel = "materialUsed")
public interface UsedMaterialJpaRepository extends JpaRepository<UsedMaterial,Integer> {
}
