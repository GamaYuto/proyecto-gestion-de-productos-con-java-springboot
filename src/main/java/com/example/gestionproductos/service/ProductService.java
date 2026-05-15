package com.example.gestionproductos.service;

import com.example.gestionproductos.dto.ProductDTO;
import com.example.gestionproductos.entity.Product;
import com.example.gestionproductos.exception.ProductNotFoundException;
import com.example.gestionproductos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Page<ProductDTO> listarTodos(Pageable pageable) {
        return repository.findAll(pageable).map(this::convertToDTO);
    }

    public ProductDTO guardar(ProductDTO dto) {
        Product product = convertToEntity(dto);
        return convertToDTO(repository.save(product));
    }

    public ProductDTO obtenerPorId(Long id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public ProductDTO actualizar(Long id, ProductDTO dto) {
        return repository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(dto.getName());
                    existingProduct.setDescription(dto.getDescription());
                    existingProduct.setPrice(dto.getPrice());
                    existingProduct.setStock(dto.getStock());
                    existingProduct.setCategory(dto.getCategory());
                    return convertToDTO(repository.save(existingProduct));
                })
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    private ProductDTO convertToDTO(Product entity) {
        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getStock(),
                entity.getCategory(),
                entity.getCreatedAt()
        );
    }

    private Product convertToEntity(ProductDTO dto) {
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setStock(dto.getStock());
        entity.setCategory(dto.getCategory());
        // createdAt is handled by @PrePersist
        return entity;
    }
}
