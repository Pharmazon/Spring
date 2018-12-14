package ru.shcheglov.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shcheglov.dto.ResultDTO;
import ru.shcheglov.dto.SuccessDTO;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

@RestController
@RequestMapping("SimpleService")
public class SimpleREST {

    @GetMapping(value = "pingJSON", produces = "application/json")
    public ResultDTO pingJSON() {
        return new SuccessDTO();
    }

    @GetMapping(value = "pingJSONKey/{apiKey}", produces = "application/json")
    public ResultDTO pingJSONKey(
            @RequestHeader("apiKey") final String key
    ) {
        return new SuccessDTO();
    }

    @GetMapping(value = "pingXML", produces = "application/xml")
    public ResultDTO pingXML() {
        return new SuccessDTO();
    }
    
}
