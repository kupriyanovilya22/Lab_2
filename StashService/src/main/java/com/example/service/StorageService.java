package com.example.service;

import com.example.model.StorageEntity;
import com.example.model.StorageDTO;
import com.example.repository.StorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageService {
    private final StorageRepo storageRepo;

    @Autowired
    public StorageService(StorageRepo storageRepo) {
        this.storageRepo = storageRepo;
    }

    public List<StorageDTO> getProductsByCategory(String category) {
        List<StorageEntity> storageEntities = storageRepo.findByCategory(category);
        List<StorageDTO> products = new ArrayList<>();
        for (StorageEntity storageEntity : storageEntities) {
            StorageDTO productDTO = new StorageDTO();
            productDTO.setId(storageEntity.getId());
            productDTO.setName(storageEntity.getName());
            productDTO.setQuantity(storageEntity.getQuantity());
            productDTO.setCategory(storageEntity.getCategory());
            productDTO.setDescription(storageEntity.getDescription());
            products.add(productDTO);
        }
        return products;
    }

    public void addProduct(StorageDTO storageDTO) {
        StorageEntity storageEntity = new StorageEntity();
        storageEntity.setId(storageDTO.getId());
        storageEntity.setName(storageDTO.getName());
        storageEntity.setQuantity(storageDTO.getQuantity());
        storageEntity.setCategory(storageDTO.getCategory());
        storageEntity.setDescription(storageDTO.getDescription());
        storageRepo.save(storageEntity);
    }
}

