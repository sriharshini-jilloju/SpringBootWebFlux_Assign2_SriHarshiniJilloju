package com.midterm.accounts.service;



import com.midterm.accounts.model.Checking;
import com.midterm.accounts.repository.CheckingRepository;


import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CheckingService {
	private final CheckingRepository repository;
	

    public Mono<Checking> save(Checking checking) {
        return repository.save(checking);
    }

    public Flux<Checking> getAll() {
        return repository.findAll();
    }
    public Mono<Checking> update(String id, Checking updatedChecking) {
        return repository.findById(id)
            .flatMap(existing -> {
                existing.setAccountHolder(updatedChecking.getAccountHolder());
                existing.setBalance(updatedChecking.getBalance());
                existing.setInsufficientFundFee(updatedChecking.getInsufficientFundFee());
                return repository.save(existing);
            });
    }



    // Delete by ID
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
        
    }
    public Mono<Checking> getById(String id) {
        return repository.findById(id);
    }

}

