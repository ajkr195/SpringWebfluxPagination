package com.spring.boot.rocks.repository;

import org.springframework.stereotype.Repository;

import com.spring.boot.rocks.model.UserEntity;

import reactor.core.publisher.Flux;

@Repository
public class ReactiveEntityRepository {

  public Flux<UserEntity> findAll() {
    return Flux.just(
        new UserEntity("Tendulkar"),
        new UserEntity("Haynes"),
        new UserEntity("Walsh"),
        new UserEntity("Ambrose"),
        new UserEntity("Lara"),
        new UserEntity("Marshall"),
        new UserEntity("Dev")
    );
  }
}
