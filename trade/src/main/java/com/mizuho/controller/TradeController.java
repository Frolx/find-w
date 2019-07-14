package com.mizuho.controller;

import com.mizuho.model.Price;
import com.mizuho.model.TradeInstrument;
import com.mizuho.model.Vendor;
import com.mizuho.service.TradeService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
@RequestMapping(path = "/demo")
public class TradeController {

    @Autowired
    TradeService tradeService;

    @RequestMapping(value = "/instrument/price/getAll", method = RequestMethod.GET)
    public String getTradeInstrumentPrices(Locale locale, Model model) {

        return "home";
    }

    @RequestMapping(value = "/vendor/prices/get", method = RequestMethod.GET)
    public String getVendorPrices(Locale locale, Model model) {

        return "home";
    }

    @RequestMapping(value = "/vendor/add/{vendorName}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String addVendor(@PathVariable Vendor vendorName) {
//        tradeService.addVendor(vendorName);
        return "Vendor " + vendorName + " added.";
    }

    @RequestMapping(value = "/vendor/instrument/add/{vendor}/{tradeInstrument}/{price}", method = RequestMethod.POST,  produces = "application/json")
    @ResponseBody
    public String addInstrumentToVendor(@PathVariable Vendor vendor, @PathVariable TradeInstrument tradeInstrument, @PathVariable float price) {
//        try {
//           // JsonUtil.jsonToPrice(payload);
////            ObjectMapper objectMapper = new ObjectMapper();
////            SimpleModule module = new SimpleModule();
////            module.addDeserializer(Price.class, new PriceDeserializer());
////            objectMapper.registerModule(module);
////            Price itemWithOwner = objectMapper.readValue(payload, Price.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //prices.get(0);
        tradeService.addPricedInstrumentToVendor(vendor, tradeInstrument, price);
        new Price(vendor, tradeInstrument, new DateTime(), price);
        return "home";
    }
}
