package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    private HashMap<String, Order> orderMap;
    private HashMap<String, DeliveryPartner> partnerMap;
    private HashMap<String, HashSet<String>> partnerToOrderMap;
    private HashMap<String, String> orderToPartnerMap;

    public OrderRepository(){
        this.orderMap = new HashMap<String, Order>();
        this.partnerMap = new HashMap<String, DeliveryPartner>();
        this.partnerToOrderMap = new HashMap<String, HashSet<String>>();
        this.orderToPartnerMap = new HashMap<String, String>();
    }

    public void saveOrder(Order order){
        // your code here
        orderMap.put(order.getId(), order);
    }

    public void savePartner(String partnerId){
        // your code here
        // create a new partner with given partnerId and save it
        partnerMap.put(partnerId, new DeliveryPartner(partnerId));
    }

    public void saveOrderPartnerMap(String orderId, String partnerId){
        if(orderMap.containsKey(orderId) && partnerMap.containsKey(partnerId)){
            // your code here
            //add order to given partner's order list
            //increase order count of partner
            //assign partner to this order
            partnerToOrderMap.computeIfAbsent(partnerId, k -> new HashSet<>()).add(orderId);
            orderToPartnerMap.put(orderId, partnerId);
            partnerMap.get(partnerId).setNumberOfOrders(partnerToOrderMap.get(partnerId).size());
        }
    }

    public Order findOrderById(String orderId){
        // your code here
        return orderMap.get(orderId);
    }

    public DeliveryPartner findPartnerById(String partnerId){
        // your code here
        return partnerMap.get(partnerId);
    }

    public Integer findOrderCountByPartnerId(String partnerId){
        // your code here
        return partnerToOrderMap.getOrDefault(partnerId, new HashSet<>()).size();
    }

    public List<String> findOrdersByPartnerId(String partnerId){
        // your code here
        return new ArrayList<>(partnerToOrderMap.getOrDefault(partnerId, new HashSet<>()));
    }

    public List<String> findAllOrders(){
        // your code here
        // return list of all orders
        return new ArrayList<>(orderMap.keySet());
    }

    public void deletePartner(String partnerId){
        // your code here
        // delete partner by ID
        partnerMap.remove(partnerId);
        partnerToOrderMap.remove(partnerId);
    }

    public void deleteOrder(String orderId){
        // your code here
        // delete order by ID
        orderMap.remove(orderId);
        String partnerId = orderToPartnerMap.remove(orderId);
        if (partnerId != null) {
            partnerToOrderMap.get(partnerId).remove(orderId);
        }
    }

    public Integer findCountOfUnassignedOrders(){
        // your code here
        return orderMap.size() - orderToPartnerMap.size();
    }

    public Integer findOrdersLeftAfterGivenTimeByPartnerId(String timeString, String partnerId){
        // your code here
        int time = Integer.parseInt(timeString.split(":")[0]) * 60 + Integer.parseInt(timeString.split(":")[1]);
        return (int) partnerToOrderMap.getOrDefault(partnerId, new HashSet<>()).stream()
                .map(orderMap::get)
                .filter(order -> order.getDeliveryTime() > time)
                .count();

    }

    public String findLastDeliveryTimeByPartnerId(String partnerId){
        // your code here
        // code should return string in format HH:MM
        return partnerToOrderMap.getOrDefault(partnerId, new HashSet<>()).stream()
                .map(orderMap::get)
                .mapToInt(Order::getDeliveryTime)
                .max()
                .isPresent() ? String.format("%02d:%02d",
                partnerToOrderMap.getOrDefault(partnerId, new HashSet<>()).stream()
                        .map(orderMap::get)
                        .mapToInt(Order::getDeliveryTime)
                        .max().getAsInt() / 60,
                partnerToOrderMap.getOrDefault(partnerId, new HashSet<>()).stream()
                        .map(orderMap::get)
                        .mapToInt(Order::getDeliveryTime)
                        .max().getAsInt() % 60)
                : "00:00";

    }
}