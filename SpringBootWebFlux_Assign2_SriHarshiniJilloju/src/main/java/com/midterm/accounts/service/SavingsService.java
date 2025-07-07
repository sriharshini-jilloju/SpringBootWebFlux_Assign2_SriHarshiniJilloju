package com.midterm.accounts.service;




import com.midterm.accounts.model.Savings;

import com.midterm.accounts.repository.SavingsRepository;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SavingsService {
	private final SavingsRepository repository;
	

	
    public Mono<Savings> save(Savings savings) {
        return repository.save(savings);
    }

    public Flux<Savings> getAll() {
        return repository.findAll();
    }
    public Mono<Savings> update(String id, Savings updatedSavings) {
        return repository.findById(id)
            .flatMap(existingSavings -> {
                existingSavings.setAccountHolder(updatedSavings.getAccountHolder());
                existingSavings.setBalance(updatedSavings.getBalance());
                existingSavings.setinterestRate(updatedSavings.getinterestRate());
                
                return repository.save(existingSavings);
            });
    }

    // Delete by ID
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }
    public Mono<Savings> getById(String id) {
        return repository.findById(id);
    }

    
}

