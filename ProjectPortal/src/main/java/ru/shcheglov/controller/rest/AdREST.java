package ru.shcheglov.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shcheglov.dto.AdDTO;
import ru.shcheglov.dto.FailDTO;
import ru.shcheglov.dto.ResultDTO;
import ru.shcheglov.dto.SuccessDTO;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Category;
import ru.shcheglov.model.Company;
import ru.shcheglov.service.AdService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Alexey Shcheglov
 * @version dated 15.12.2018
 */

@RestController
@RequestMapping("AdService")
public class AdREST {

    @Autowired
    private AdService adService;

    @GetMapping(value = "ping", produces = "application/json")
    public ResultDTO ping() {
        return new ResultDTO();
    }

    @GetMapping(value = "createAd", produces = "application/json")
    public AdDTO createAd() {
        try {
            final Ad ad = new Ad();
            ad.setName("New ad");
            ad.setContent("11");
            adService.save(ad);
            return new AdDTO(ad);
        } catch (final Exception e) {
            return null;
        }
    }

    @GetMapping(value = "getAdList", produces = "application/json")
    public List<AdDTO> getAdList() {
        try {
            final List<Ad> ads = adService.getAll();
            return ads.stream()
                    .map(AdDTO::new)
                    .collect(Collectors.toList());
        } catch (final Exception e) {
            return Collections.emptyList();
        }
    }

    @GetMapping(value = "getAdById/{id}", produces = "application/json")
    public AdDTO getAdById(@PathVariable("id") final String id) {
        try {
            final Optional<Ad> ad = adService.get(id);
            return ad.map(AdDTO::new).orElse(null);
        } catch (final Exception e) {
            return null;
        }
    }

    @PostMapping(value = "mergeAd", produces = "application/json", consumes = "application/json")
    public ResultDTO mergeAd(final AdDTO dto) {
        try {
            adService.save(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @PostMapping(value = "mergeAds", produces = "application/json", consumes = "application/json")
    public ResultDTO mergeAds(final AdDTO[] dtos) {
        try {
            for (final AdDTO dto : dtos) adService.save(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @GetMapping(value = "deleteAdById/{id}", produces = "application/json")
    public ResultDTO deleteAdById(@PathVariable("id") final String id) {
        try {
            adService.delete(id);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @PostMapping(value = "deleteAd", produces = "application/json", consumes = "application/json")
    public ResultDTO deleteAd(final AdDTO dto) {
        try {
            adService.delete(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

    @DeleteMapping(value = "deleteAds", produces = "application/json")
    public ResultDTO deleteAds(final AdDTO[] dtos) {
        try {
            for (final AdDTO dto : dtos) adService.delete(dto);
            return new SuccessDTO();
        } catch (final Exception e) {
            return new FailDTO(e);
        }
    }

}
