package com.gremlinengine.generator.rest.utility;

import com.gremlinengine.generator.rest.model.dto.CvDto;
import com.gremlinengine.generator.rest.model.entity.Address;
import com.gremlinengine.generator.rest.model.entity.Cv;
import com.gremlinengine.generator.rest.model.entity.Link;
import com.gremlinengine.generator.rest.model.entity.Theme;

import java.util.List;

public final class CvUtil {

    public static void handleLinks(CvDto cvDto, Cv target) {
        List<Link> newLinks = cvDto.links().stream()
                .map(linkDto -> {
                    Link existingLink = target.getLinks().stream()
                            .filter(link -> link.getPlatform().equals(linkDto.getPlatform()))
                            .findFirst()
                            .orElse(null);
                    if (existingLink != null) {
                        existingLink.setUrl(linkDto.getUrl());
                        return existingLink;
                    } else {
                        return new Link(linkDto.getPlatform(), linkDto.getUrl());
                    }
                })
                .toList();
        target.getLinks().removeIf(link ->
                newLinks.stream().noneMatch(newLink ->
                        link.getPlatform().equals(newLink.getPlatform())
                )
        );
        target.getLinks().clear();
        target.getLinks().addAll(newLinks);
    }

    public static void handleAddress(CvDto cvDto, Cv target) {
        if (cvDto.address() != null) {
            var address = target.getAddress();
            if (address == null) {
                address = new Address();
                address.setCv(target);
                target.setAddress(address);
            }
            address.setStreet(cvDto.address().getStreet());
            address.setCity(cvDto.address().getCity());
            address.setState(cvDto.address().getState());
            address.setCountry(cvDto.address().getCountry());
            address.setPostalCode(cvDto.address().getPostalCode());
        } else {
            target.setAddress(null);
        }
    }

    public static void handleTheme(CvDto cvDto, Cv target) {
        if (cvDto.theme() != null) {
            Theme theme = target.getTheme();
            if (theme == null) {
                theme = new Theme(cvDto.theme().getName(), cvDto.theme().getFileName());
                target.setTheme(theme);
            } else {
                if (!theme.getName().equals(cvDto.theme().getName())) {
                    theme.setName(cvDto.theme().getName());
                }
                if (!theme.getFileName().equals(cvDto.theme().getFileName())) {
                    theme.setFileName(cvDto.theme().getFileName());
                }
            }
        }
    }

    private CvUtil() { /* Empty constructor to prohibit initialisation. */ }

}
