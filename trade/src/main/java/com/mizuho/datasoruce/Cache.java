package com.mizuho.datasoruce;

import com.mizuho.model.Price;
import com.mizuho.model.TradeInstrument;
import com.mizuho.model.Vendor;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Cache {
    private final Map<Vendor, List<Price>> cache = new ConcurrentHashMap<>();
    private final int EXPIRITY_CHECK_PERIOD_SEC = 10;
    public Cache() {
        Thread cleanUpThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(EXPIRITY_CHECK_PERIOD_SEC * 1000);
                    cache.values().stream().flatMap(Stream::of).map(x -> x.removeIf( y ->isTradeExpired(y.getPublishedDate())));

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        cleanUpThread.setDaemon(true);
        cleanUpThread.start();

    }
    public void add(Price insPrice) {
        Vendor vendor = insPrice.getVendor();
        add(vendor, insPrice);
    }

    public void add(Vendor vendor, Price instrumentPrice) {
        if(cache.containsKey(vendor)) {
            cache.get(vendor).add(instrumentPrice);
        } else {
            add(vendor);
            add(vendor, instrumentPrice);
        }
    }

    public void add(Vendor vendor) {
        if(cache.containsKey(vendor)) {
            System.out.println("Vendor Exists");
            return;
        }
        cache.put(vendor, new ArrayList<>());
    }

    public Vendor get(String vendorName) {
        Optional<Vendor> optionalVendor = cache.keySet().stream().filter(x -> x.getName().contentEquals(vendorName)).findAny();
        if(optionalVendor.isPresent()) {
            return optionalVendor.get();
        }

        System.out.println("Vendor doesn't exists");
        return null;
    }



    public List<Price> getVendorPrices(Vendor vendor) {
        if(cache.containsKey(vendor)) {
            return cache.get(vendor);
        }

        return null;
    }

    public Map<Vendor, List<Price>> getAll() {
        return cache;
    }

    public List<Price> getAllPrices(String tradeInstrumentName) {
        return cache.values().stream().flatMap(Collection::stream).filter(x -> x.getTradeInstrument().getName().equals(tradeInstrumentName)).collect(Collectors.toList());
    }

    private boolean isTradeExpired(DateTime instrumentDateTime) {
        final int NUMBER_OF_DAYS_BEFORE_EXPIRITY = 30;
        DateTime dateTime = new DateTime();
        return Days.daysBetween(dateTime, instrumentDateTime).getDays() > NUMBER_OF_DAYS_BEFORE_EXPIRITY;
    }
}
