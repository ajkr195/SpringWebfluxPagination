package com.spring.boot.rocks.service;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.boot.rocks.helper.PageSupport;
import com.spring.boot.rocks.model.UserEntity;
import com.spring.boot.rocks.repository.ReactiveEntityRepository;

import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EntityService {

  private final ReactiveEntityRepository repository;

  public Mono<PageSupport<UserEntity>> getEntityPage(Pageable page) {
    return repository.findAll()
        .collectList()
        .map(list -> new PageSupport<>(
            list
                .stream()
                .skip(page.getPageNumber() * page.getPageSize())
                .limit(page.getPageSize())
                .collect(Collectors.toList()),
            page.getPageNumber(), page.getPageSize(), list.size()));
  }

}
