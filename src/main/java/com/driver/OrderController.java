//package com.driver;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("orders")
//public class OrderController {
//
//    @Autowired
//    private OrderService orderService;
//
//    @PostMapping("/add-order")
//    public ResponseEntity<String> addOrder(@RequestBody Order order){
//        orderService.addOrder(order);
//        return new ResponseEntity<>("New order added successfully", HttpStatus.CREATED);
//    }
//
//    @PostMapping("/add-partner/{partnerId}")
//    public ResponseEntity<String> addPartner(@PathVariable String partnerId){
//        orderService.addPartner(partnerId);
//        return new ResponseEntity<>("New delivery partner added successfully", HttpStatus.CREATED);
//    }
//
//    @PutMapping("/add-order-partner-pair")
//    public ResponseEntity<String> addOrderPartnerPair(@RequestParam String orderId, @RequestParam String partnerId){
//
//        //This is basically assigning that order to that partnerId
//        orderService.createOrderPartnerPair(orderId, partnerId);
//        return new ResponseEntity<>("New order-partner pair added successfully", HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get-order-by-id/{orderId}")
//    public ResponseEntity<Order> getOrderById(@PathVariable String orderId){
//
//        //Order order= null;
//        //order should be returned with an orderId.
//        //order=orderService.getOrderById(orderId);
//
//        //return new ResponseEntity<>(order, HttpStatus.CREATED);
//        return new ResponseEntity<>(orderService.getOrderById(orderId), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get-partner-by-id/{partnerId}")
//    public ResponseEntity<DeliveryPartner> getPartnerById(@PathVariable String partnerId){
//
//        //DeliveryPartner deliveryPartner = null;
//
//        //deliveryPartner should contain the value given by partnerId
//
//        //return new ResponseEntity<>(deliveryPartner, HttpStatus.CREATED);
//        return new ResponseEntity<>(orderService.getPartnerById(partnerId), HttpStatus.CREATED);
//
//    }
//
//    @GetMapping("/get-order-count-by-partner-id/{partnerId}")
//    public ResponseEntity<Integer> getOrderCountByPartnerId(@PathVariable String partnerId){
//
//        //Integer orderCount = 0;
//
//        //orderCount should denote the orders given by a partner-id
//
//        //return new ResponseEntity<>(orderCount, HttpStatus.CREATED);
//        return new ResponseEntity<>(orderService.getOrderCountByPartnerId(partnerId), HttpStatus.CREATED);
//
//    }
//
//    @GetMapping("/get-orders-by-partner-id/{partnerId}")
//    public ResponseEntity<List<String>> getOrdersByPartnerId(@PathVariable String partnerId){
//        List<String> orders = null;
//
//        //orders should contain a list of orders by PartnerId
//        orders=orderService.getOrdersByPartnerId(partnerId);
//
//        return new ResponseEntity<>(orders, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get-all-orders")
//    public ResponseEntity<List<String>> getAllOrders(){
//        List<String> orders = null;
//
//        //Get all orders
//        orders=orderService.getAllOrders();
//        return new ResponseEntity<>(orders, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get-count-of-unassigned-orders")
//    public ResponseEntity<Integer> getCountOfUnassignedOrders(){
//        Integer countOfOrders = 0;
//
//        //Count of orders that have not been assigned to any DeliveryPartner
//        countOfOrders=orderService.getCountOfUnassignedOrders();
//
//        return new ResponseEntity<>(countOfOrders, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get-count-of-orders-left-after-given-time/{time}/{partnerId}")
//    public ResponseEntity<Integer> getOrdersLeftAfterGivenTimeByPartnerId(@PathVariable String time, @PathVariable String partnerId){
//
//        Integer countOfOrders = 0;
//
//        //countOfOrders that are left after a particular time of a DeliveryPartner
//        countOfOrders=orderService.getOrdersLeftAfterGivenTimeByPartnerId(time, partnerId);
//
//        return new ResponseEntity<>(countOfOrders, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get-last-delivery-time/{partnerId}")
//    public ResponseEntity<String> getLastDeliveryTimeByPartnerId(@PathVariable String partnerId){
//        String time = null;
//
//        //Return the time when that partnerId will deliver his last delivery order.
//        time=orderService.getLastDeliveryTimeByPartnerId(partnerId);
//
//        return new ResponseEntity<>(time, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/delete-partner-by-id/{partnerId}")
//    public ResponseEntity<String> deletePartnerById(@PathVariable String partnerId){
//
//        //Delete the partnerId
//        //And push all his assigned orders to unassigned orders.
//        orderService.deletePartner(partnerId);
//        return new ResponseEntity<>(partnerId + " removed successfully", HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/delete-order-by-id/{orderId}")
//    public ResponseEntity<String> deleteOrderById(@PathVariable String orderId){
//
//        //Delete an order and also
//        // remove it from the assigned order of that partnerId
//        orderService.deleteOrder(orderId);
//
//        return new ResponseEntity<>(orderId + " removed successfully", HttpStatus.CREATED);
//    }
//}

package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("orders")




public class OrderController {

    @Autowired
    private OrderService orderService=new OrderService();

    @PostMapping("/add-order")
    public ResponseEntity<String> addOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return new ResponseEntity<>("New order added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-partner/{partnerId}")
    public ResponseEntity<String> addPartner(@PathVariable String partnerId){
        orderService.addPartner(partnerId);
        return new ResponseEntity<>("New delivery partner added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-order-partner-pair")
    public ResponseEntity<String> addOrderPartnerPair(@RequestParam String orderId, @RequestParam String partnerId){
        orderService.createOrderPartnerPair(orderId, partnerId);
        //This is basically assigning that order to that partnerId
        return new ResponseEntity<>("New order-partner pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-order-by-id/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable String orderId){

        Order order= null;
        //order should be returned with an orderId.
        order = orderService.getOrderById(orderId);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/get-partner-by-id/{partnerId}")
    public ResponseEntity<DeliveryPartner> getPartnerById(@PathVariable String partnerId){
        partnerId = partnerId.trim(); // Trim any leading or trailing spaces
        System.out.println("Received request for partner ID: '" + partnerId + "'");
        DeliveryPartner deliveryPartner = null;

        //deliveryPartner should contain the value given by partnerId
        deliveryPartner = orderService.getPartnerById(partnerId);
        if (deliveryPartner == null) {
            System.out.println("Partner not found: " + partnerId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Found partner: " + deliveryPartner);
        return new ResponseEntity<>(deliveryPartner, HttpStatus.CREATED);
    }

    @GetMapping("/get-order-count-by-partner-id/{partnerId}")
    public ResponseEntity<Integer> getOrderCountByPartnerId(@PathVariable String partnerId){

        Integer orderCount = 0;

        //orderCount should denote the orders given by a partner-id
        orderCount = orderService.getOrderCountByPartnerId(partnerId);
        return new ResponseEntity<>(orderCount, HttpStatus.CREATED);
    }

    @GetMapping("/get-orders-by-partner-id/{partnerId}")
    public ResponseEntity<List<String>> getOrdersByPartnerId(@PathVariable String partnerId){
        List<String> orders = null;

        //orders should contain a list of orders by PartnerId
        orders = orderService.getOrdersByPartnerId(partnerId);
        return new ResponseEntity<>(orders, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-orders")
    public ResponseEntity<List<String>> getAllOrders(){
        List<String> orders = null;
        orders = orderService.getAllOrders();
        //Get all orders
        return new ResponseEntity<>(orders, HttpStatus.CREATED);
    }

    @GetMapping("/get-count-of-unassigned-orders")
    public ResponseEntity<Integer> getCountOfUnassignedOrders(){
        Integer countOfOrders = 0;

        //Count of orders that have not been assigned to any DeliveryPartner
        countOfOrders = orderService.getCountOfUnassignedOrders();
        return new ResponseEntity<>(countOfOrders, HttpStatus.CREATED);
    }

    @GetMapping("/get-count-of-orders-left-after-given-time/{time}/{partnerId}")
    public ResponseEntity<Integer> getOrdersLeftAfterGivenTimeByPartnerId(@PathVariable String time, @PathVariable String partnerId){

        Integer countOfOrders = 0;

        //countOfOrders that are left after a particular time of a DeliveryPartner
        countOfOrders = orderService.getOrdersLeftAfterGivenTimeByPartnerId(time, partnerId);

        return new ResponseEntity<>(countOfOrders, HttpStatus.CREATED);
    }

    @GetMapping("/get-last-delivery-time/{partnerId}")
    public ResponseEntity<String> getLastDeliveryTimeByPartnerId(@PathVariable String partnerId){
        String time = null;

        //Return the time when that partnerId will deliver his last delivery order.
        time= orderService.getLastDeliveryTimeByPartnerId(partnerId);
        return new ResponseEntity<>(time, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-partner-by-id/{partnerId}")
    public ResponseEntity<String> deletePartnerById(@PathVariable String partnerId){

        //Delete the partnerId
        //And push all his assigned orders to unassigned orders.
        orderService.deletePartner(partnerId);
        return new ResponseEntity<>(partnerId + " removed successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-order-by-id/{orderId}")
    public ResponseEntity<String> deleteOrderById(@PathVariable String orderId){

        //Delete an order and also
        // remove it from the assigned order of that partnerId
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(orderId + " removed successfully", HttpStatus.CREATED);
    }
}