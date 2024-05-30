package co.develhope.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorService {

    @Autowired
    private ErrorRepository repository;

    public Error createError (Error error){
        return repository.save(error);
    }

    public List<Error> retrieveAllErrors (){
        return repository.findAll();
    }
}
