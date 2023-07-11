package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Order implements Serializable {
    //public static int counterIDOrder;
    public Order(String orderID){
        this.orderID = orderID ;
    }
    public static Order LoggedInOrderForUser;
    public static Order LoggedInOrderForAdmin ;
    public ArrayList<Food> orderFoods = new ArrayList<Food>();
    public String orderID;
    public Restaurant orderedRestaurant;
    public Delivery deliveryOfOrder ;
    public STATUS orderStatus ;
    public Long deliveryTimeRemains;
    public User orderedUser;
    public double getOrderCost(){
        double totalCost = 0;
        for(Food shit : orderFoods)
            totalCost += shit.foodCost * shit.number;
        return totalCost;
    }
}