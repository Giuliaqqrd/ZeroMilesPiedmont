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

    public Company saveCompany(Company company) {
        return this.companyRepository.save(company);
    }

    public List<Company> getCompanies(){
        return this.companyRepository.findAll();
    }

    public Company getCompanyByEmail(String email) {
        return this.companyRepository.findCompanyByEmail(email);
    }

}
