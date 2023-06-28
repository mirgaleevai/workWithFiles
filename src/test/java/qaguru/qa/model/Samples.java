package qaguru.qa.model;

import java.util.List;


public class Samples {
    private String fruit;
    private String size;
    private String color;
    private List<Items> items;
    public String getFruit() {
        return fruit;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public List<Items> getItems() {
        return items;
    }

  public static class Items {
      private int productID;
      private double price;

      public int getProductID() {
          return productID;
      }

      public double getPrice() {
          return price;
      }
  }

    }





