package com.spring.boot.rocks.controller;

import lombok.RequiredArgsConstructor;

import static com.spring.boot.rocks.helper.PageSupport.DEFAULT_PAGE_SIZE;
import static com.spring.boot.rocks.helper.PageSupport.FIRST_PAGE_NUM;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.rocks.helper.PageSupport;
import com.spring.boot.rocks.model.UserEntity;
import com.spring.boot.rocks.service.EntityService;

import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class EntityController {

  private final EntityService service;

  @GetMapping("/entities")
  public Mono<PageSupport<UserEntity>> getEntitiesPage(
      @RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
      @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size
  ) {

//    return service.getEntityPage(PageRequest.of(page, size));
    return service.getEntityPage(PageRequest.of(page, size)).log();
  }
}
