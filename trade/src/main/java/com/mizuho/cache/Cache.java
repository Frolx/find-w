package com.mizuho.cache;

import com.mizuho.model.TradeInstrument;
import com.mizuho.model.Vendor;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Component
public class Cache {
    private final Map<Vendor, List<TradeInstrument>> cache = new ConcurrentHashMap<>();
    private final int EXPIRITY_CHECK_PERIOD_SEC = 10;
    public Cache() {
        Thread cleanUpThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(EXPIRITY_CHECK_PERIOD_SEC * 1000);
                    cache.values().stream().flatMap(Stream::of).map(x -> x.removeIf( y ->isTradeExpired(y.getPublishetDate())));

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        cleanUpThread.setDaemon(true);
        cleanUpThread.start();

    }

    public void addTradeInstrumentToVendor(Vendor vendor, TradeInstrument tradeInstrument) {
        //@TODO
    }

    public void addVendor(Vendor vendor) {
        //@TODO
    }

    private boolean isTradeExpired(DateTime instrumentDateTime) {
        final int NUMBER_OF_DAYS_BEFORE_EXPIRITY = 30;
        DateTime dateTime = new DateTime();
        return Days.daysBetween(dateTime, instrumentDateTime).getDays() > NUMBER_OF_DAYS_BEFORE_EXPIRITY;
    }
}
