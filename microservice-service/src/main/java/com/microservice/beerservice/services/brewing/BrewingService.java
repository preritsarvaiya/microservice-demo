package com.microservice.beerservice.services.brewing;

import com.microservice.beerservice.config.JmsConfig;
import com.microservice.beerservice.domain.Beer;
import com.microservice.beerservice.repositories.BeerRepository;
import com.microservice.beerservice.services.inventory.BeerInventoryService;
import com.microservice.beerservice.web.mapper.BeerMapper;
import com.microservice.beerservice.web.model.event.BrewBeerEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {

    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000)
    public void checkForLowInventory() {
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer inv = beerInventoryService.getOnHandInventory(beer.getId());
            log.debug("Min on hand is - " + beer.getMinOnHand());
            if(beer.getMinOnHand() >= inv) {
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });

    }
}
