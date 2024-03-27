package com.example;

import com.example.Entity.WikimediaData;
import com.example.Repository.WikimediaDataRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.time.Instant;

@Service
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);


    private final WikimediaDataRespository wikimediaDataRespository;

    public KafkaConsumer(WikimediaDataRespository wikimediaDataRespository) {
        this.wikimediaDataRespository = wikimediaDataRespository;
    }

    @KafkaListener(topics = "wikimedia_recentchange",groupId = "myGroup")
    public void consume(String eventMessage){
        logger.info(String.format("Event Message Received -> %s",eventMessage));
//        Map<String, String> hashMap = new HashMap<String, String>();
//        String[] parts = eventMessage.split(",");
//        int length = 0;
//        for (String part : parts) {
//            String[] stuData = part.split(":");
//            length = stuData.length;
//            if (length != 2) {
//                continue;
//            }
//            System.out.println(stuData);
//            String stuRollNo = stuData[0].trim();
//            String stuName = stuData[1].trim();
//            hashMap.put(stuRollNo, stuName);
//        }
//        int l = Integer.parseInt(hashMap.get("\"timestamp\""));
//        Instant instant = Instant.now();
//        long epochValue = instant.getEpochSecond();
//        try {
//            if((l+100)  < epochValue){
                WikimediaData wikimediaData = new WikimediaData();
                wikimediaData.setWikiEventData(eventMessage);
                wikimediaDataRespository.save(wikimediaData);

//        }catch (Exception e){
//            logger.error("exception ",e);
//        }

    }
}
