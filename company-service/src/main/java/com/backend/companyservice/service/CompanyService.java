package com.backend.companyservice.service;
import com.backend.companyservice.model.Company;
import com.backend.companyservice.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void saveCompany(Company company) {
        this.companyRepository.save(company);
    }

    public List<Company> getCompanies(){
        return this.companyRepository.findAll();
    }

}
