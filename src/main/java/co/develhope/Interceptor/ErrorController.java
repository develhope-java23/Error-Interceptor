package co.develhope.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCheckpointRestore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/v1/errors")
public class ErrorController {

    @Autowired
    private ErrorService errorService;

    @GetMapping
    public List<Error> loadAll() {
        return errorService.retrieveAllErrors();
    }
}
