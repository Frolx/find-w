package com.mizuho.Util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.mizuho.model.Price;
import com.mizuho.model.TradeInstrument;
import com.mizuho.model.Vendor;
import org.joda.time.DateTime;

import java.io.IOException;

public class PriceDeserializer extends StdDeserializer<Price> {

        public PriceDeserializer() {
            this(null);
        }

        public PriceDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Price deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode node = jp.getCodec().readTree(jp);
            String vendor = node.get("vendor").toString();
            Vendor vendorInstance = new ObjectMapper().readValue(vendor, Vendor.class);
            String tradeInstrument = node.get("tradeInstrument").toString();
            TradeInstrument tradeInstrumentInstance = new ObjectMapper().readValue(tradeInstrument, TradeInstrument.class);
            String publishedDate = node.get("publishedDate").toString();
            DateTime publishedDateInstance = new ObjectMapper().readValue(publishedDate, DateTime.class);

            return new Price(vendorInstance, tradeInstrumentInstance, publishedDateInstance, 2F);
        }
}
