package com.backend.companyservice.repository;

import com.backend.companyservice.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {
    List<Company> findAllCompanyById(String id);

    Company findCompanyByEmail(String email);

}
