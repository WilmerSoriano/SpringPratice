package com.devtiro.database.mappers;
// The implementation basics for Entity=> DTO and DTO=>Entity
public interface Mapper<A,B> {

    B mapTo(A a);

    A mapFrom(B b);

}
