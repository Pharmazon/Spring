package ru.shcheglov.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.dto.AdDTO;
import ru.shcheglov.dto.ResultDTO;
import ru.shcheglov.model.Ad;
import ru.shcheglov.service.AdService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Alexey Shcheglov
 * @version dated 14.12.2018
 */

@RestController
@RequestMapping("api/ads")
public class AdsResource {

    @Autowired
    private AdService adService;

    @GetMapping(produces = "application/json")
    public List<AdDTO> get() {
        final List<Ad> ads = adService.getAll();
        return ads.stream()
                .map(AdDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO post(final AdDTO[] ads) {
        for (final AdDTO ad : ads) adService.save(ad);
        return new ResultDTO();
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO put(final AdDTO[] ads) {
        for (final AdDTO ad : ads) adService.save(ad);
        return new ResultDTO();
    }

    @DeleteMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO delete(final AdDTO[] ads) {
        for (final AdDTO ad : ads) adService.delete(ad);
        return new ResultDTO();
    }

}
