package ru.shcheglov.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.dto.AdDTO;
import ru.shcheglov.dto.ResultDTO;
import ru.shcheglov.model.Ad;
import ru.shcheglov.service.AdService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexey Shcheglov
 * @version dated 27.12.2018
 */

@RestController
@RequestMapping("api/ads")
public class AdsResource {

    @Autowired
    private AdService adService;

    @GetMapping(produces = "application/json")
    public List<AdDTO> get() {
        final List<Ad> entities = adService.getAll();
        return entities.stream()
                .map(AdDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO post(final AdDTO[] dtos) {
        for (final AdDTO dto : dtos) adService.saveOne(dto);
        return new ResultDTO();
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO put(final AdDTO[] dtos) {
        for (final AdDTO dto : dtos) adService.saveOne(dto);
        return new ResultDTO();
    }

    @DeleteMapping(produces = "application/json", consumes = "application/json")
    public ResultDTO delete(final AdDTO[] dtos) {
        for (final AdDTO dto : dtos) adService.deleteOne(dto);
        return new ResultDTO();
    }
}
