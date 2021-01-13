package com.sametakbal.api.dao.interfaces;

import java.util.UUID;

public interface IDao<E> {
    boolean save(E e);
    boolean delete(UUID uuid);
    boolean get();
}
