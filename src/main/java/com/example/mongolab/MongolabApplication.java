package com.example.mongolab;

import com.example.mongolab.dtos.CatchDto;
import com.example.mongolab.dtos.FishermenDto;
import com.example.mongolab.dtos.FishingSpotsDto;
import com.example.mongolab.enums.FishType;
import com.example.mongolab.enums.FishermenNames;
import com.example.mongolab.enums.RodType;
import com.example.mongolab.enums.SpotsLocation;
import com.example.mongolab.models.Fishermen;
import com.example.mongolab.services.FishermenService;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class MongolabApplication {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        return modelMapper;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MongolabApplication.class);
        app.setDefaultProperties(Collections.singletonMap("spring.profiles.default", "mongodb"));
        app.run(args);
    }

    @Component
    public class CustomCode implements CommandLineRunner {
        @Autowired
        private FishermenService fishermenService;
        @Autowired
        private ModelMapper modelMapper;

        @Override
        public void run(String... args) {
            Random random = new Random();
            FishType[] fishTypes = FishType.values();
            RodType[] rodTypes = RodType.values();
            FishermenNames[] fishermenNames = FishermenNames.values();
            SpotsLocation[] spotsLocations = SpotsLocation.values();

            // Создание рыбаков с уловами и водоемами внутри
            for (int i = 0; i < 10; i++) {
                FishermenDto newFishermen = new FishermenDto();
                newFishermen.setId(new ObjectId()); // Устанавливаем новый ID
                newFishermen.setName(fishermenNames[random.nextInt(fishermenNames.length)]);
                newFishermen.setAge(18 + random.nextInt(50));
                newFishermen.setLicenseId("License_" + i);

                // Генерация уловов для каждого рыбака
                List<CatchDto> catches = new ArrayList<>();
                for (int j = 0; j < random.nextInt(5) + 1; j++) {
                    CatchDto newCatch = new CatchDto();
                    newCatch.setId(new ObjectId()); // Устанавливаем новый ID
                    newCatch.setFishType(fishTypes[random.nextInt(fishTypes.length)]);
                    newCatch.setWeight(1 + random.nextDouble() * 9);
                    newCatch.setCatchTime(LocalDate.now().minusDays(random.nextInt(30)));
                    newCatch.setRodType(rodTypes[random.nextInt(rodTypes.length)]);
                    catches.add(newCatch);
                }
                newFishermen.setCatches(catches);

                // Генерация водоемов для каждого рыбака
                List<FishingSpotsDto> fishingSpots = new ArrayList<>();
                for (int j = 0; j < random.nextInt(3) + 1; j++) {
                    FishingSpotsDto newFishingSpot = new FishingSpotsDto();
                    newFishingSpot.setId(new ObjectId()); // Устанавливаем новый ID
                    newFishingSpot.setSpotsLocation(spotsLocations[random.nextInt(spotsLocations.length)]);
                    newFishingSpot.setFeedback("Feedback_" + j);
                    fishingSpots.add(newFishingSpot);
                }
                newFishermen.setFishingSpots(fishingSpots);

                Fishermen fishermenEntity = modelMapper.map(newFishermen, Fishermen.class);
                fishermenService.createFishermen(newFishermen);
            }
        }
    }

}
