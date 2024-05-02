package com.backend.companyservice.repository;

import com.backend.companyservice.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompanyRepository extends MongoRepository<Company, String> {
    List<CompanyRepository> findAllCompanyById(String id);
}
