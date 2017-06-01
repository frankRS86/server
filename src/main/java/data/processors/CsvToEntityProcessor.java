package main.java.data.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class CsvToEntityProcessor implements ItemProcessor<String, String> {

    private static final Logger log = LoggerFactory.getLogger(CsvToEntityProcessor.class);

    @Override
    public String process(final String person) throws Exception {


        log.info("Converting (" + person + ") into (" + person + ")");

        return person;
    }

}