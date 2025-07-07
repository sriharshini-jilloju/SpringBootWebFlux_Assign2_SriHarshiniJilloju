package com.midterm.accounts.controller;

import com.midterm.accounts.model.Checking;
import com.midterm.accounts.service.CheckingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/checking")
@RequiredArgsConstructor
public class CheckingController {

    private final CheckingService checkingService;

    @PostMapping
    public Mono<Checking> save(@RequestBody Checking checking) {
        return checkingService.save(checking);
    }

    @GetMapping
    public Flux<Checking> getAll() {
        return checkingService.getAll();
    }
    @PutMapping("/{id}")
    public Mono<Checking> update(@PathVariable String id, @RequestBody Checking checking) {
        return checkingService.update(id, checking);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return checkingService.deleteById(id);
        
    }
    @GetMapping("/{id}")
    public Mono<Checking> getById(@PathVariable String id) {
        return checkingService.getById(id);
    }

}

