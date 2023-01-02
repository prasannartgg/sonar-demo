package au.com.tgg.apps.foundation.service;


import au.com.tgg.apps.foundation.dto.ResponseDTO;

public interface CrudService<T> {
    ResponseDTO insert(T t) throws Exception;
    ResponseDTO update(T t) throws Exception;
    ResponseDTO delete(T t) throws Exception;
}
