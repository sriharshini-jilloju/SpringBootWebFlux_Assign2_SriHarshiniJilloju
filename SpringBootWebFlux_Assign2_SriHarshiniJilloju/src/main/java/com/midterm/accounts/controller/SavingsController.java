package com.midterm.accounts.controller;



import com.midterm.accounts.model.Savings;

import com.midterm.accounts.service.SavingsService;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/savings")
@RequiredArgsConstructor
public class SavingsController {
	private final SavingsService savingService ; 
    @PostMapping
    public Mono<Savings> save(@RequestBody Savings savings) {
        return savingService.save(savings);
    }

    @GetMapping
    public Flux<Savings> getAll() {
        return savingService.getAll();
    }
    @PutMapping("/{id}")
    public Mono<Savings> update(@PathVariable String id, @RequestBody Savings savings) {
        return savingService.update(id, savings);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return savingService.deleteById(id);
    }
    @GetMapping("/{id}")
    public Mono<Savings> getById(@PathVariable String id) {
        return savingService.getById(id);
    }

}

