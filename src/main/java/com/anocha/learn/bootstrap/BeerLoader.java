//package com.anocha.learn.bootstrap;
//
//
//import com.anocha.learn.domain.Beer;
//import com.anocha.learn.model.BeerStyleEnum;
//import com.anocha.learn.repositories.BeerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.util.function.Consumer;
//
//@Component
//public class BeerLoader implements CommandLineRunner {
//
//    @Autowired
//    BeerRepository beerRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        loadBeerObject.accept("");
//    }
//
//    private Consumer loadBeerObject = (obj) -> {
//        if (beerRepository.count() == 0) {
//            Beer beerDto = Beer.builder()
//                    .beerName("ABC")
//                    .beerStyle(BeerStyleEnum.GOSE.name())
//                    .quantityToBrew(200)
//                    .upc(44720030030303L)
//                    .price(new BigDecimal("12.95")).build();
//            beerRepository.save(beerDto);
//
//            Beer beerDtoT = Beer.builder()
//                    .beerName("XYZ")
//                    .beerStyle(BeerStyleEnum.PORTER.name())
//                    .quantityToBrew(200)
//                    .upc(33420030030303L)
//                    .price(new BigDecimal("14.95")).build();
//            beerRepository.save(beerDtoT);
//
//        }
//    };
//}
