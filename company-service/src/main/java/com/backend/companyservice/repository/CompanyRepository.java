package com.backend.companyservice.repository;

import com.backend.companyservice.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface CompanyRepository extends MongoRepository<Company, String> {
    List<Company> findAllCompanyById(String id);

    Company findCompanyByEmail(String email);

}
