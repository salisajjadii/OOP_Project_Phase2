package Functions;
import Classes.*;
import java.io.*;
import Map.Map ;

import java.sql.SQLOutput;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Functions implements Serializable {
    public static Scanner scanner = new Scanner(System.in);

    public static String[] checkPassword(String password, String Role, String userName, StaticArrayLists staticArrayLists) {
        String[] answer = {"true", "0", "false", ""};
        boolean numberic = false;
        boolean capitalLetter = false;
        boolean smallLetter = false;
        int passwordLength = password.length();
        for (int i = 0; i < password.length(); i++) {
            int asciiCode = (int) (password.charAt(i));
            if (asciiCode <= 57 && asciiCode >= 48) {
                numberic = true;
            }
        }
        for (int i = 0; i < password.length(); i++) {
            int asciiCode = (int) (password.charAt(i));
            if (asciiCode <= 90 && asciiCode >= 65) {
                capitalLetter = true;
            }
        }
        for (int i = 0; i < password.length(); i++) {
            int asciiCode = (int) (password.charAt(i));
            if (asciiCode <= 122 && asciiCode >= 97) {
                smallLetter = true;
            }
        }
        if (!numberic) {
            answer[0] = "false";
            answer[1] = "1";
        }
        if (!capitalLetter) {
            answer[0] = "false";
            answer[1] = "2";
        }
        if (!smallLetter) {
            answer[0] = "false";
            answer[1] = "3";
        }
        if (passwordLength < 8) {
            answer[0] = "false";
            answer[1] = "4";
        }
        if (numberic && capitalLetter && smallLetter && passwordLength >= 8) {
            if (Role.equals("ADMIN")) {
                answer[3] = "ADMIN";
                if (isUserNameUnique(userName, Role, staticArrayLists)) {
                    Admin admin = new Admin(userName, password, setID("admin", staticArrayLists));
                    staticArrayLists.adminStaticArrayList.add(admin);
                } else {
                    answer[2] = "true";
                }
            } else if (Role.equals("USER")) {
                answer[3] = "USER";
                if (isUserNameUnique(userName, Role, staticArrayLists)) {
                    User user = new User(userName, password, setID("user", staticArrayLists));
                    user.userLocation = setRandomLocation(staticArrayLists);
                    staticArrayLists.userStaticArrayList.add(user);
                } else {
                    answer[2] = "true";
                }
            } else if (Role.equals("DELIVERY")) {
                answer[3] = "DELIVERY";
                if (isUserNameUnique(userName, Role, staticArrayLists)) {
                    Delivery delivery = new Delivery(userName, password, setID("delivery", staticArrayLists));
                    staticArrayLists.deliveriesArraylist.add(delivery);
                    delivery.deliveryLocation = setRandomLocation(staticArrayLists);
                } else {
                    answer[2] = "true";
                }
            }
        }
        return answer;
    }

    public static String[] LogIn(String password, String Role, String userName, StaticArrayLists staticArrayLists) {
        if (Role.equals("ADMIN")) {
            if (isUserNameUnique(userName, Role, staticArrayLists)) {
                String[] result = {"false", "", "", ""};
                return result;
            } else {
                Admin admin = staticArrayLists.adminStaticArrayList.get(findRoleIndex(userName, Role, staticArrayLists));
                if (admin.getPassword().equals(password)) {
                    Classes.Role.loggedInRole = admin;
                    Classes.Role.loggedInRoleExistance = true;
                    if (admin.adminRestaurants.size() == 1) {
                        Restaurant.loggedInRestaurantForAdmin = admin.adminRestaurants.get(0);
                        String[] result = {"true", "true", admin.adminID, "1"};
                        return result;
                    } else {
                        String[] result = {"true", "true", admin.adminID, "2"};
                        showRestaurantList(admin);
                        return result;
                    }
                } else {
                    String[] result = {"true", "false", "", ""};
                    return result;
                }
            }
        } else if (Role.equals("USER")) {
            if (isUserNameUnique(userName, Role, staticArrayLists)) {
                String[] result = {"false", "", "", ""};
                return result;
            } else {
                User user = staticArrayLists.userStaticArrayList.get(findRoleIndex(userName, Role, staticArrayLists));
                if (user.getPassword().equals(password)) {
                    Classes.Role.loggedInRole = user;
                    Classes.Role.loggedInRoleExistance = true;
                    String[] result = {"true", "true", user.userID, ""};
                    return result;
                } else {
                    String[] result = {"true", "false", "", ""};
                    return result;
                }
            }
        } else if (Role.equals("DELIVERY")) {
            if (isUserNameUnique(userName, Role, staticArrayLists)) {
                String[] result = {"false", "", "", ""};
                return result;
            } else {
                Delivery delivery = staticArrayLists.deliveriesArraylist.get(findRoleIndex(userName, Role, staticArrayLists));
                if (delivery.getPassword().equals(password)) {
                    Classes.Role.loggedInRole = delivery;
                    Classes.Role.loggedInRoleExistance = true;
                    String[] result = {"true", "true", delivery.deliveryID, ""};
                    return result;
                } else {
                    String[] result = {"true", "false", "", ""};
                    return result;
                }
            }
        } else {
            String[] result = {"false", "false", "", ""};
            return result;
        }
    }

    public static boolean isUserNameUnique(String UserName, String Role, StaticArrayLists staticArrayLists) {
        boolean isUserNameUnique = true;
        if (Role.equals("ADMIN")) {
            for (int i = 0; i < staticArrayLists.adminStaticArrayList.size(); i++) {
                if (staticArrayLists.adminStaticArrayList.get(i).getUserName().equals(UserName)) {
                    isUserNameUnique = false;
                }
            }
        } else if (Role.equals("USER")) {
            for (int i = 0; i < staticArrayLists.userStaticArrayList.size(); i++) {
                if (staticArrayLists.userStaticArrayList.get(i).getUserName().equals(UserName)) {
                    isUserNameUnique = false;
                }
            }
        } else if (Role.equals("DELIVERY")) {
            for (int i = 0; i < staticArrayLists.deliveriesArraylist.size(); i++) {
                if (staticArrayLists.deliveriesArraylist.get(i).getUserName().equals(UserName)) {
                    isUserNameUnique = false;
                }
            }
        }
        return isUserNameUnique;
    }

    public static int findRoleIndex(String userName, String Role, StaticArrayLists staticArrayLists) {
        int index = 0;
        if (Role.equals("ADMIN")) {
            for (int i = 0; i < staticArrayLists.adminStaticArrayList.size(); i++) {
                if (staticArrayLists.adminStaticArrayList.get(i).getUserName().equals(userName)) {
                    index = i;
                }
            }
        } else if (Role.equals("USER")) {
            for (int i = 0; i < staticArrayLists.userStaticArrayList.size(); i++) {
                if (staticArrayLists.userStaticArrayList.get(i).getUserName().equals(userName)) {
                    index = i;
                }
            }
        } else if (Role.equals("DELIVERY")) {
            for (int i = 0; i < staticArrayLists.deliveriesArraylist.size(); i++) {
                if (staticArrayLists.deliveriesArraylist.get(i).getUserName().equals(userName)) {
                    index = i;
                }
            }
        }
        return index;
    }

    public static String makeSecurityQuestion(Role role) {
        double randomNumber = (Math.random()) * 5;
        int randomInt = (int) randomNumber;
        String Question = new String("");
        String Answer;
        if (randomInt == 0) {
            Question = new String("What is your favourite color ? : ");
        } else if (randomInt == 1) {
            Question = new String("What is your favourite food ? : ");
        } else if (randomInt == 2) {
            Question = new String("What is your favourite soccer team ? : ");
        } else if (randomInt == 3) {
            Question = new String("What is your favourite actor/actress ? : ");
        } else if (randomInt == 4) {
            Question = new String("What is your favourite movie ? : ");
        }
        role.securityQuestion = new String(Question);
        return Question;
    }

    public static boolean searchRestaurant(Admin admin, String ID) {
        boolean restaurantExistance = false;
        for (int i = 0; i < admin.adminRestaurants.size(); i++) {
            if (admin.adminRestaurants.get(i).restaurantID.equals(ID)) {
                restaurantExistance = true;
                Restaurant.loggedInRestaurantForAdmin = admin.adminRestaurants.get(i);
            }
        }
        return restaurantExistance;
    }

    public static List<String> showFoodType() {
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        List<String> foodtype = new ArrayList<>();
        for (int i = 0; i < restaurant.restaurantFoodType.size(); i++) {
            String entry = (i + 1) + ". " + restaurant.restaurantFoodType.get(i);
            foodtype.add(entry);
        }
        return foodtype;
    }

    public static String setID(String thingString, StaticArrayLists staticArrayLists) {
        String firstchapter = new String("");
        String ID = new String("");
        int counter = 0;
        int randomNumber = (int) (((Math.random()) * 9999) + 1);
        if (thingString.equals("restaurant")) {
            firstchapter = new String("R");
            staticArrayLists.counterIDRestaurant++;
            counter = staticArrayLists.counterIDRestaurant;
        } else if (thingString.equals("food")) {
            firstchapter = new String("F");
            staticArrayLists.counterIDFood++;
            counter = staticArrayLists.counterIDFood;
        } else if (thingString.equals("comment")) {
            firstchapter = new String("C");
            staticArrayLists.counterIDComment++;
            counter = staticArrayLists.counterIDComment;
        } else if (thingString.equals("order")) {
            firstchapter = new String("O");
            staticArrayLists.counterIDOrder++;
            counter = staticArrayLists.counterIDOrder;
        } else if (thingString.equals("rating")) {
            firstchapter = new String("RA");
            staticArrayLists.counterIDRating++;
            counter = staticArrayLists.counterIDRating;
        } else if (thingString.equals("delivery")) {
            firstchapter = new String("D");
            staticArrayLists.counterIDDelivery++;
            counter = staticArrayLists.counterIDDelivery;
        } else if (thingString.equals("admin")) {
            firstchapter = new String("A");
            staticArrayLists.counterIDAdmin++;
            counter = staticArrayLists.counterIDAdmin;
        } else if (thingString.equals("user")) {
            firstchapter = new String("U");
            staticArrayLists.counterIDUser++;
            counter = staticArrayLists.counterIDUser;
        }
        ID = firstchapter + randomNumber + counter;
        return ID;
    }

    public static List<String> showMenuForAdmin() {
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        List<String> foodList = new ArrayList<>();
        for (int i = 0; i < restaurant.restaurantMenu.size(); i++) {
            Food food = restaurant.restaurantMenu.get(i);
            String entry = "food name : " + food.foodName + " * food id : " + food.foodID + " * food cost : " + food.foodCost;
            foodList.add(entry);
        }
        return foodList;
    }

    public static boolean addFood(String foodName, int foodCost, StaticArrayLists staticArrayLists) {
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        boolean foodExistance = false;
        for (int i = 0; i < restaurant.restaurantMenu.size(); i++) {
            if (foodName.equals(restaurant.restaurantMenu.get(i).foodName)) {
                foodExistance = true;
            }
        }
        return foodExistance;
    }

    public static List<String> showRestaurantList(Admin admin) {
        List<String> restaurantList = new ArrayList<>();
        for (int i = 0; i < admin.adminRestaurants.size(); i++) {
            Restaurant restaurant = admin.adminRestaurants.get(i);
            String entry = "Restaurant Name : " + restaurant.restaurantName + " , Restaurant ID : " + restaurant.restaurantID;
            restaurantList.add(entry);
        }
        return restaurantList;
    }

    public static void deactiveFood(String foodID) {
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        boolean foodIDExistance = foodIDExistanceChecker(restaurant, foodID);
        if (foodIDExistance) {
            Food food = foodIDfounder(restaurant, foodID);
            if (food.possibilityOfOrdering) {
                if (food.activeOrder) {
                    System.out.println("You can't deactive a food when it has active order!");
                } else {
                    System.out.println("Are you sure you want to deactive this food ?");
                    String answer = scanner.nextLine();
                    if (answer.toLowerCase().equals("yes")) {
                        food.possibilityOfOrdering = false;
                        System.out.println("food deactived successfully!");
                    }
                }
            } else {
                System.out.println("food has been deactive!");
            }

        } else {
            System.out.println("this foodID doesn't exist in this restaurant!");
        }
    }

    public static boolean foodIDExistanceChecker(Restaurant restaurant, String foodID) {
        boolean foodIDExistance = false;
        for (int i = 0; i < restaurant.restaurantMenu.size(); i++) {
            if (foodID.equals(restaurant.restaurantMenu.get(i).foodID)) {
                foodIDExistance = true;
            }
        }
        return foodIDExistance;
    }

    public static Food foodIDfounder(Restaurant restaurant, String foodID) {
        Food food = restaurant.restaurantMenu.get(0);
        for (int i = 0; i < restaurant.restaurantMenu.size(); i++) {
            if (foodID.equals(restaurant.restaurantMenu.get(i).foodID)) {
                food = restaurant.restaurantMenu.get(i);
            }
        }
        return food;
    }

    public static boolean commentIDExistanceChecker(String commentID) {
        Food food = Food.selectedFoodForAdmin;
        boolean commentExistance = false;
        for (int i = 0; i < food.foodCommentsArrayList.size(); i++) {
            if (commentID.equals(food.foodCommentsArrayList.get(i).commentID)) {
                commentExistance = true;
            }
        }
        return commentExistance;
    }

    public static Comment commentFounder(String commentID) {
        Food food = Food.selectedFoodForAdmin;
        Comment comment = food.foodCommentsArrayList.get(0);
        for (int i = 0; i < food.foodCommentsArrayList.size(); i++) {
            if (commentID.equals(food.foodCommentsArrayList.get(i).commentID)) {
                comment = food.foodCommentsArrayList.get(i);
            }
        }
        return comment;
    }

    public static List<String> displayOpenOrders() {
        List<String> orderList = new ArrayList<>();
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        for (int i = 0; i < restaurant.restaurantOrders.size(); i++) {
            Order order = restaurant.restaurantOrders.get(i);
            String entry = (i + 1) + ". ";
            for (Food food : order.orderFoods) {
                entry += "  " + food.number + " " + food.foodName + " * " + order.orderID + "\t";
            }
            orderList.add(entry);
        }
        return orderList;
    }

    public static List<String> showOrderHistory() {
        List<String> orderHistory = new ArrayList<>();
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        for (int i = 0; i < restaurant.restaurantOrdersHistory.size(); i++) {
            Order order = restaurant.restaurantOrdersHistory.get(i);
            String entry = (i + 1) + ". ";
            for (Food food : order.orderFoods)
                entry += "  " + food.number + food.foodName + " * " + food.foodID;
            orderHistory.add(entry);
        }
        return orderHistory;
    }

    public static List<String> showOrderHistoryForUser() {
        List<String> orderHistory = new ArrayList<>();
        User user = (User) Role.loggedInRole;
        for (int i = 0; i < user.userOrders.size(); i++) {
            Order order = user.userOrders.get(i);
            String entry = (i + 1) + ". Restaurant : " + order.orderedRestaurant.restaurantName + " orderID : " + order.orderID;
            orderHistory.add(entry);
        }
        return orderHistory;
    }

    public static String[] orderIdExistanceChecker(String orderID) {
        String[] answer = {"false", ""};
        User uesr = (User) Role.loggedInRole;
        for (int i = 0; i < uesr.userOrders.size(); i++) {
            if (uesr.userOrders.get(i).orderID.equals(orderID)) {
                answer[0] = "true";
                answer[1] = Integer.toString(i);
            }
        }
        return answer;
    }

    public static List<String> orderDetailsList(Order order) {
        List<String> orderDetails = new ArrayList<>();
        int i = 1;
        for (Food food : order.orderFoods) {
            String entry = i + ". " + food.number + food.foodName + " - " + food.foodCost + "$";
            i++;
            orderDetails.add(entry);
        }
        return orderDetails;
    }

    public static int confirmOrder(User user, String orderID) {
        int k = -1;
        for (int i = 0; i < user.userCart.cartorders.size(); i++)
            if (user.userCart.cartorders.get(i).orderID.equals(orderID))
                k = i;
        return k;
    }

    public static List<String> showAllAvailableRestaurants(StaticArrayLists staticArrayLists, String shit) {
        List<String> availableRestaurants = new ArrayList<>();
        if (staticArrayLists.allRestaurantsArrayList.size() == 0) {
            String entry = "Sorry, There is no available restaurant at this time !!!";
            availableRestaurants.add(entry);
        } else if (staticArrayLists.allRestaurantsArrayList.size() != 0 && shit.equals("Suggested")) {
            User user = (User) Role.loggedInRole;
            int userLocation = user.userLocation;
            if (user.userOrders.size() == 0) {
                for (int i = 0; i < staticArrayLists.allRestaurantsArrayList.size(); i++)
                    if (Math.abs(staticArrayLists.allRestaurantsArrayList.get(i).restaurantLocation - userLocation) < 300) {
                        String entry = "Restaurant \"" + staticArrayLists.allRestaurantsArrayList.get(i).restaurantName + "\" -> with the ID \"" + staticArrayLists.allRestaurantsArrayList.get(i).restaurantID + "\"";
                        availableRestaurants.add(entry);
                    }
                for (int i = 0; i < staticArrayLists.allRestaurantsArrayList.size(); i++)
                    if (Math.abs(staticArrayLists.allRestaurantsArrayList.get(i).restaurantLocation - userLocation) >= 300) {
                        String entry = "Restaurant \"" + staticArrayLists.allRestaurantsArrayList.get(i).restaurantName + "\" -> with the ID \"" + staticArrayLists.allRestaurantsArrayList.get(i).restaurantID + "\"";
                        availableRestaurants.add(entry);
                    }
            } else {
                for (int i = 0; i < user.userOrders.size(); i++)
                    for (int j = 0; j < user.userOrders.get(i).orderedRestaurant.restaurantFoodType.size(); j++)
                        for (int k = 0; k < staticArrayLists.allRestaurantsArrayList.size(); k++)
                            for (int l = 0; l < staticArrayLists.allRestaurantsArrayList.get(k).restaurantFoodType.size(); l++)
                                if (user.userOrders.get(i).orderedRestaurant.restaurantFoodType.get(j).equals(staticArrayLists.allRestaurantsArrayList.get(k).restaurantFoodType.get(l))) {
                                    String entry = "Restaurant \"" + staticArrayLists.allRestaurantsArrayList.get(k).restaurantName + "\" -> with the ID \"" + staticArrayLists.allRestaurantsArrayList.get(k).restaurantID + "\"";
                                    availableRestaurants.add(entry);
                                }
                for (int i = 0; i < user.userOrders.size(); i++)
                    for (int j = 0; j < user.userOrders.get(i).orderedRestaurant.restaurantFoodType.size(); j++)
                        for (int k = 0; k < staticArrayLists.allRestaurantsArrayList.size(); k++)
                            for (int l = 0; l < staticArrayLists.allRestaurantsArrayList.get(k).restaurantFoodType.size(); l++)
                                if (!user.userOrders.get(i).orderedRestaurant.restaurantFoodType.get(j).equals(staticArrayLists.allRestaurantsArrayList.get(k).restaurantFoodType.get(l))) {
                                    String entry = "Restaurant \"" + staticArrayLists.allRestaurantsArrayList.get(k).restaurantName + "\" -> with the ID \"" + staticArrayLists.allRestaurantsArrayList.get(k).restaurantID + "\"";
                                    availableRestaurants.add(entry);
                                }
            }
        } else if (staticArrayLists.allRestaurantsArrayList.size() != 0 && shit.equals("Normal")) {
            for (int i = 0; i < staticArrayLists.allRestaurantsArrayList.size(); i++) {
                String entry = "Restaurant \"" + staticArrayLists.allRestaurantsArrayList.get(i).restaurantName + "\" -> with the ID \"" + staticArrayLists.allRestaurantsArrayList.get(i).restaurantID + "\"";
                availableRestaurants.add(entry);
            }
        }
        return availableRestaurants;
    }

    public static List<String> showRelatedRestaurants(String name, StaticArrayLists staticArrayLists) {
        List<String> availableRestaurants = new ArrayList<>();
        boolean found = false;
        for (int i = 0; i < staticArrayLists.allRestaurantsArrayList.size(); i++)
            if (staticArrayLists.allRestaurantsArrayList.get(i).restaurantName.toLowerCase().contains(name.toLowerCase()))
                found = true;
        if (found) {
            for (int i = 0; i < staticArrayLists.allRestaurantsArrayList.size(); i++)
                if (staticArrayLists.allRestaurantsArrayList.get(i).restaurantName.toLowerCase().contains(name.toLowerCase())) {
                    String entry = "Restaurant \"" + staticArrayLists.allRestaurantsArrayList.get(i).restaurantName + "\" -> with the ID \"" + staticArrayLists.allRestaurantsArrayList.get(i).restaurantID + "\" found!";
                    availableRestaurants.add(entry);
                }
        } else {
            String entry = "There is no related restaurant with this name !!!";
            availableRestaurants.add(entry);
        }
        return availableRestaurants;
    }

    public static int selectRestaurant(String restaurantID, StaticArrayLists staticArrayLists) {
        int k = -1;
        for (int i = 0; i < staticArrayLists.allRestaurantsArrayList.size(); i++)
            if (staticArrayLists.allRestaurantsArrayList.get(i).restaurantID.equals(restaurantID))
                k = i;
        return k;
    }

    public static List<String> showMenuForUser(Restaurant restaurant) {
        List<String> availableRestaurants = new ArrayList<>();
        if (restaurant.restaurantMenu.size() == 0) {
            String entry = "Sorry, There is no available food for you at this time !!!";
            availableRestaurants.add(entry);
        } else {
            for (int i = 0; i < restaurant.restaurantMenu.size(); i++) {
                String entry = "Food \"" + restaurant.restaurantMenu.get(i).foodName + "\" with the ID \"" + restaurant.restaurantMenu.get(i).foodID + "\" and the price " + restaurant.restaurantMenu.get(i).foodCost + "$";
                availableRestaurants.add(entry);
            }
        }
        return availableRestaurants;
    }

    public static List<String> showRelatedFoods(String name) {
        List<String> availableRestaurants = new ArrayList<>();
        boolean found = false;
        for (int i = 0; i < Restaurant.loggedInRestaurantForUser.restaurantMenu.size(); i++)
            if (Restaurant.loggedInRestaurantForUser.restaurantMenu.get(i).foodName.contains(name))
                found = true;
        if (found) {
            for (int i = 0; i < Restaurant.loggedInRestaurantForUser.restaurantMenu.size(); i++)
                if (Restaurant.loggedInRestaurantForUser.restaurantMenu.get(i).foodName.contains(name)) {
                    String entry = "Food \"" + Restaurant.loggedInRestaurantForUser.restaurantMenu.get(i).foodName + "\" -> with the ID \"" + Restaurant.loggedInRestaurantForUser.restaurantMenu.get(i).foodID + "\" found!";
                    availableRestaurants.add(entry);
                }
        } else {
            String entry = "There is no related food with this name !!!";
            availableRestaurants.add(entry);
        }
        return availableRestaurants;
    }

    public static int selectFood(String foodID) {
        int k = -1;
        for (int i = 0; i < Restaurant.loggedInRestaurantForUser.restaurantMenu.size(); i++)
            if (Restaurant.loggedInRestaurantForUser.restaurantMenu.get(i).foodID.equals(foodID))
                k = i;
        return k;
    }

    public static List<String> showRestaurantComments(Restaurant restaurant) {
        List<String> availableRestaurants = new ArrayList<>();
        if (restaurant.restaurantCommentsArrayList.size() == 0) {
            String entry = "There is no comment about this restaurant!";
            availableRestaurants.add(entry);
        } else {
            for (int i = 0; i < restaurant.restaurantCommentsArrayList.size(); i++) {
                String entry = "Comment ID: \"" + restaurant.restaurantCommentsArrayList.get(i).commentID + "\" -> \"" + restaurant.restaurantCommentsArrayList.get(i).commentedUser.userID + "\" says: " + restaurant.restaurantCommentsArrayList.get(i).comment;
                availableRestaurants.add(entry);
            }
        }
        return availableRestaurants;
    }

    public static void addRestaurantComment(StaticArrayLists staticArrayLists, String comment) {
        Restaurant.loggedInRestaurantForUser.restaurantCommentsArrayList.add(new Comment());
        Restaurant.loggedInRestaurantForUser.restaurantCommentsArrayList.get(Restaurant.loggedInRestaurantForUser.restaurantCommentsArrayList.size() - 1).comment = comment;
        Restaurant.loggedInRestaurantForUser.restaurantCommentsArrayList.get(Restaurant.loggedInRestaurantForUser.restaurantCommentsArrayList.size() - 1).commentID = setID("comment", staticArrayLists);
        Restaurant.loggedInRestaurantForUser.restaurantCommentsArrayList.get(Restaurant.loggedInRestaurantForUser.restaurantCommentsArrayList.size() - 1).commentedUser = (User) Role.loggedInRole;
    }

    public static int editRestaurantComment(String commentID) {
        int k = -1;
        for (int i = 0; i < Restaurant.loggedInRestaurantForUser.restaurantCommentsArrayList.size(); i++)
            if (Restaurant.loggedInRestaurantForUser.restaurantCommentsArrayList.get(i).commentID.equals(commentID))
                k = i;
        return k;
    }

    public static List<String> showRestaurantRatings(Restaurant restaurant) {
        List<String> availableRestaurants = new ArrayList<>();
        if (restaurant.restaurantRatingsArrayList.size() == 0) {
            String entry = "There is no rating about this restaurant!";
            availableRestaurants.add(entry);
        } else {
            for (int i = 0; i < restaurant.restaurantRatingsArrayList.size(); i++) {
                String entry = "Rating ID: \"" + restaurant.restaurantRatingsArrayList.get(i).ratingID + "\" -> \"" + restaurant.restaurantRatingsArrayList.get(i).ratedUser.userID + "\" rated: " + restaurant.restaurantRatingsArrayList.get(i).rating;
                availableRestaurants.add(entry);
            }
        }
        return availableRestaurants;
    }

    public static int getRestaurantRating(User user, Restaurant restaurant) {
        int k = -1;
        for (int i = 0; i < restaurant.restaurantRatingsArrayList.size(); i++)
            if (restaurant.restaurantRatingsArrayList.get(i).ratedUser == user)
                k = i;
        return k;
    }

    public static List<String> showFoodComments() {
        List<String> availableFoods = new ArrayList<>();
        if (Food.selectedFoodForUser.foodCommentsArrayList.size() == 0) {
            String entry = "There is no comment about this restaurant!";
            availableFoods.add(entry);
        } else {
            for (int i = 0; i < Food.selectedFoodForUser.foodCommentsArrayList.size(); i++) {
                String entry = "Comment ID: \"" + Food.selectedFoodForUser.foodCommentsArrayList.get(i).commentID + "\" -> \"" + Food.selectedFoodForUser.foodCommentsArrayList.get(i).commentedUser.userID + "\" says: " + Food.selectedFoodForUser.foodCommentsArrayList.get(i).comment;
                availableFoods.add(entry);
            }
        }
        return availableFoods;
    }

    public static void addFoodComment(StaticArrayLists staticArrayLists, String comment) {
        Food.selectedFoodForUser.foodCommentsArrayList.add(new Comment());
        Food.selectedFoodForUser.foodCommentsArrayList.get(Food.selectedFoodForUser.foodCommentsArrayList.size() - 1).comment = comment;
        Food.selectedFoodForUser.foodCommentsArrayList.get(Food.selectedFoodForUser.foodCommentsArrayList.size() - 1).commentID = setID("comment", staticArrayLists);
        Food.selectedFoodForUser.foodCommentsArrayList.get(Food.selectedFoodForUser.foodCommentsArrayList.size() - 1).commentedUser = (User) Role.loggedInRole;
    }

    public static int editFoodComment(String commentID) {
        int k = -1;
        for (int i = 0; i < Food.selectedFoodForUser.foodCommentsArrayList.size(); i++)
            if (Food.selectedFoodForUser.foodCommentsArrayList.get(i).commentID.equals(commentID))
                k = i;
        return k;
    }

    public static List<String> showFoodRatings() {
        List<String> availableFoods = new ArrayList<>();
        if (Food.selectedFoodForUser.foodRatingsArrayList.size() == 0) {
            String entry = "There is no rating about this food!";
            availableFoods.add(entry);
        } else {
            for (int i = 0; i < Food.selectedFoodForUser.foodRatingsArrayList.size(); i++) {
                String entry = "Rating ID: \"" + Food.selectedFoodForUser.foodRatingsArrayList.get(i).ratingID + "\" -> \"" + Food.selectedFoodForUser.foodRatingsArrayList.get(i).ratedUser.userID + "\" rated: " + Food.selectedFoodForUser.foodRatingsArrayList.get(i).rating;
                availableFoods.add(entry);
            }
        }
        return availableFoods;
    }

    public static int getFoodRating(User user) {
        int k = -1;
        for (int i = 0; i < Food.selectedFoodForUser.foodRatingsArrayList.size(); i++)
            if (Food.selectedFoodForUser.foodRatingsArrayList.get(i).ratedUser == user)
                k = i;
        return k;
    }

    public static List<String> showCartStatus(User user) {
        List<String> cartList = new ArrayList<>();
        if (user.userCart.cartorders.size() == 0) {
            String entry = "You have no orders in your cart";
            cartList.add(entry);
        } else {
            for (int i = 0; i < user.userCart.cartorders.size(); i++) {
                String entry = (i + 1) + "-> From the restaurant \"" + user.userCart.cartorders.get(i).orderedRestaurant.restaurantName + "\" " + "with the total cost " + user.userCart.cartorders.get(i).getOrderCost() + "$ " + "and the ID \"" + user.userCart.cartorders.get(i).orderID + "\".";
                cartList.add(entry);
            }
        }
        return cartList;
    }

    public static void addFoodToCart(User user, Restaurant restaurant, Food food, StaticArrayLists staticArrayLists) {
        int l = -1;
        for (int i = 0; i < staticArrayLists.userStaticArrayList.size(); i++)
            if (user.userID.equals(staticArrayLists.userStaticArrayList.get(i).userID))
                l = i;
        if (user.userCart.cartorders.size() != 0) {
            int k = -1;
            for (int i = 0; i < user.userCart.cartorders.size(); i++)
                if (restaurant.restaurantID.equals(user.userCart.cartorders.get(i).orderedRestaurant.restaurantID))
                    k = i;
            if (k == -1) {
                Order order = new Order(Functions.setID("order", staticArrayLists));
                food.number = 1;
                order.orderFoods.add(food);
                order.orderedRestaurant = restaurant;
                order.orderedUser = user;
                staticArrayLists.userStaticArrayList.get(l).userCart.cartorders.add(order);
                System.out.println("Added successfully");
            } else {
                food.number = 1;
                staticArrayLists.userStaticArrayList.get(l).userCart.cartorders.get(k).orderFoods.add(food);
                System.out.println("Added successfully");
            }
        } else {
            Order order = new Order(Functions.setID("order", staticArrayLists));
            food.number = 1;
            order.orderFoods.add(food);
            order.orderedRestaurant = restaurant;
            order.orderedUser = user;
            staticArrayLists.userStaticArrayList.get(l).userCart.cartorders.add(order);
            System.out.println("Added successfully");
        }
    }

    public static List<String> showOrderDetailsForUser(Order order) {
        List<String> orderDetails = new ArrayList<>();
        int i = 1;
        for (Food food : order.orderFoods) {
            String entry = i + "- " + food.number + " " + food.foodName + " with the ID: " + food.foodID;
            orderDetails.add(entry);
        }
        return orderDetails;
    }

    public static int setRandomLocation(StaticArrayLists staticArrayLists) {
        int randomNumber = (int) (Math.random() * 1000);
        boolean locationExistance = false;
        for (int i = 0; i < staticArrayLists.LocationArrayList.size(); i++) {
            if (staticArrayLists.LocationArrayList.get(i) == randomNumber) {
                locationExistance = true;
            }
        }
        if (locationExistance) {
            return setRandomLocation(staticArrayLists);
        } else {
            return randomNumber;
        }
    }

    public static List<String> showOrdersListForDelivery(StaticArrayLists staticArrayLists) {
        List<String> ordersWithoutDelivery = new ArrayList<>();
        Delivery delivery = (Delivery) Role.loggedInRole;
        for (int i = 0; i < staticArrayLists.OrdersWithoutDeliveryArrayList.size(); i++) {
            Order order = staticArrayLists.OrdersWithoutDeliveryArrayList.get(i);
            String entry = (i + 1) + ". order Id : " + order.orderID + " * Restaurant Location : " + order.orderedRestaurant.restaurantLocation;
            ordersWithoutDelivery.add(entry);
        }
        return ordersWithoutDelivery;
    }

    public static String[] selectOrderForDelivery(StaticArrayLists staticArrayLists, String orderID, Map map) {
        String[] answer = {"false", ""};
        Delivery delivery = (Delivery) Role.loggedInRole;
        boolean orderExistance = false;
        int orderIndex = 0;
        for (int i = 0; i < staticArrayLists.OrdersWithoutDeliveryArrayList.size(); i++) {
            if (staticArrayLists.OrdersWithoutDeliveryArrayList.get(i).orderID.equals(orderID)) {
                answer[0] = "true";
                answer[1] = Integer.toString(i);
                orderExistance = true;
                orderIndex = i;
            }
        }
        if (orderExistance) {
            Order order = staticArrayLists.OrdersWithoutDeliveryArrayList.get(orderIndex);
            delivery.activeOrder = order;
            order.deliveryOfOrder = delivery;
            staticArrayLists.StaticOrderDelivery = order;
            delivery.activeOrderBoolean = true;
            staticArrayLists.OrdersWithoutDeliveryArrayList.remove(order);
        }
        return answer;
    }

    public static List<String> displayCommentsForAdmin() {
        List<String> comments = new ArrayList<>();
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        for (int i = 0; i < restaurant.restaurantCommentsArrayList.size(); i++) {
            Comment comment = restaurant.restaurantCommentsArrayList.get(i);
            String entry = "User " + comment.commentedUser.getUserName() + " commented : " + comment.comment + " , comment ID : " + comment.commentID;
            comments.add(entry);
        }
        return comments;
    }

    public static String[] commentIdExistance(String commentId) {
        Restaurant restaurant = Restaurant.loggedInRestaurantForAdmin;
        String[] answer = {"false", "0"};
        for (int i = 0; i < restaurant.restaurantCommentsArrayList.size(); i++) {
            if (commentId.equals(restaurant.restaurantCommentsArrayList.get(i).commentID)) {
                answer[0] = "true";
                answer[1] = Integer.toString(i);
            }
        }
        return answer;
    }
}