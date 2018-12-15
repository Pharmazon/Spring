package ru.shcheglov.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.dto.AdDTO;
import ru.shcheglov.dto.ResultDTO;
import ru.shcheglov.model.Ad;
import ru.shcheglov.service.AdService;

import java.util.Optional;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

@RestController
@RequestMapping("api/ad")
public class AdRest {

    @Autowired
    private AdService adService;

    @GetMapping(value = "{id}", produces = "application/json")
    public AdDTO get(@PathVariable("id") final String id) {
        final Optional<Ad> ad = adService.get(id);
        return ad.map(AdDTO::new).orElse(null);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO post(final AdDTO adDTO) {
        adService.save(adDTO);
        return new ResultDTO();
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO put(final AdDTO adDTO) {
        adService.save(adDTO);
        return new ResultDTO();
    }

    @DeleteMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO delete(final AdDTO adDTO) {
        adService.delete(adDTO);
        return new ResultDTO();
    }

}
